import { useState, useEffect } from "react";
import DeleteBookDialog from "../components/product/DeleteBookDialog.tsx";
import EditBookDialog from "../components/product/EditBookDialog.tsx";
import useBooks from "../hooks/useBooks.ts";
import type { Book, BookFormData } from "../api/types/book.ts";
import LoadingSpinner from "../components/layout/LoadingSpinner.tsx";
import ErrorMessage from "../components/layout/ErrorMessage.tsx";
import Header from "../components/layout/Header.tsx";
import AddBookDialog from "../components/product/AddBookDialog.tsx";
import {
    Box, Button, Grid, IconButton, ToggleButton,
    ToggleButtonGroup, Typography
} from "@mui/material";
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import EntityCard from "../components/layout/EntityCard.tsx";
import BookApi from "../api/booksapi.ts";

const Books = () => {
    const { books, loading, error, onAdd, onDelete, onEdit } = useBooks();
    const [selectedState, setSelectedState] = useState<string | null>(null);
    const [openAdd, setOpenAdd] = useState(false);
    const [bookToDelete, setBookToDelete] = useState<Book | null>(null);
    const [bookToEdit, setBookToEdit] = useState<Book | null>(null);
    const [wishlistIds, setWishlistIds] = useState<number[]>([]);

    useEffect(() => {
        BookApi.getWishlist()
            .then(wishlist => setWishlistIds(wishlist.books.map((b: any) => b.id)))
            .catch(() => {});
    }, []);

    if (loading) return <LoadingSpinner />;
    if (error) return <ErrorMessage message={error} />;

    const filteredBooks = selectedState
        ? books.filter(book => book.state === selectedState)
        : books;

    const handleAdd = async (data: BookFormData) => {
        await onAdd(data);
        setOpenAdd(false);
    };

    const handleDelete = async (id: number) => {
        await onDelete(id);
        setBookToDelete(null);
    };

    const handleEdit = async (id: number, data: BookFormData) => {
        await onEdit(id, data);
        setBookToEdit(null);
    };

    const handleWishlist = async (bookId: number) => {
        try {
            if (wishlistIds.includes(bookId)) {
                await BookApi.removeFromWishlist(bookId);
                setWishlistIds(prev => prev.filter(id => id !== bookId));
            } else {
                await BookApi.addToWishlist(bookId);
                setWishlistIds(prev => [...prev, bookId]);
            }
        } catch (e) {
            console.error("Wishlist error", e);
        }
    };

    return (
        <>
            <Header title="Books" subtitle={`Total: ${filteredBooks.length} books`} />

            <Box sx={{ display: 'flex', justifyContent: 'flex-end', mb: 2 }}>
                <Button variant="contained" onClick={() => setOpenAdd(true)}>Add Book</Button>
            </Box>

            <AddBookDialog open={openAdd} onClose={() => setOpenAdd(false)} onAdd={handleAdd} />

            {bookToDelete && (
                <DeleteBookDialog
                    book={bookToDelete}
                    open={!!bookToDelete}
                    onClose={() => setBookToDelete(null)}
                    onDelete={handleDelete}
                />
            )}
            {bookToEdit && (
                <EditBookDialog
                    book={bookToEdit}
                    open={!!bookToEdit}
                    onClose={() => setBookToEdit(null)}
                    onEdit={handleEdit}
                />
            )}

            <Box sx={{ mb: 3 }}>
                <Typography variant="subtitle1" sx={{ mb: 1, color: 'white' }}>
                    Filter by State:
                </Typography>
                <ToggleButtonGroup
                    value={selectedState}
                    exclusive
                    onChange={(_, value) => setSelectedState(value)}
                    sx={{
                        '& .MuiToggleButton-root': { color: 'white', borderColor: 'white' },
                        '& .Mui-selected': { backgroundColor: 'rgba(255,255,255,0.2)' }
                    }}
                >
                    <ToggleButton value="GOOD" color="success">GOOD</ToggleButton>
                    <ToggleButton value="BAD" color="error">BAD</ToggleButton>
                </ToggleButtonGroup>
            </Box>

            <Grid container spacing={3}>
                {filteredBooks.map((book) => (
                    <Grid size={{ xs: 12, sm: 6, md: 4 }} key={book.id}>
                        <EntityCard
                            title={book.name}
                            navigateTo={`/books/${book.id}`}
                            onEdit={() => setBookToEdit(book)}
                            onDelete={() => setBookToDelete(book)}
                            extraActions={
                                <IconButton
                                    size="small"
                                    onClick={() => handleWishlist(book.id)}
                                    color="error"
                                >
                                    {wishlistIds.includes(book.id)
                                        ? <FavoriteIcon fontSize="small" />
                                        : <FavoriteBorderIcon fontSize="small" />}
                                </IconButton>
                            }
                            fields={[
                                { label: 'Category', value: book.category, chip: true },
                                { label: 'Author', value: book.authorFullName },
                                { label: 'State', value: book.state, chip: true },
                                { label: 'Available Copies', value: book.availableCopies },
                            ]}
                        />
                    </Grid>
                ))}
            </Grid>
        </>
    );
};

export default Books;