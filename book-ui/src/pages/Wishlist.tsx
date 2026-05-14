import { useEffect, useState } from "react";
import { Box, Grid, IconButton, Typography } from "@mui/material";
import FavoriteIcon from "@mui/icons-material/Favorite";
import EntityCard from "../components/layout/EntityCard.tsx";
import BookApi from "../api/booksapi.ts";
import LoadingSpinner from "../components/layout/LoadingSpinner.tsx";
import ErrorMessage from "../components/layout/ErrorMessage.tsx";

interface Book {
    id: number;
    title: string;
    category: string;
    bookState: string;
    availableCopies: number;
    author: {
        name: string;
        surname: string;
    };
}

const WishlistPage = () => {
    const [books, setBooks] = useState<Book[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        BookApi.getWishlist()
            .then(wishlist => {
                setBooks(wishlist.books || []);
                setLoading(false);
            })
            .catch(() => {
                setError("Failed to load wishlist");
                setLoading(false);
            });
    }, []);

    const handleRemove = async (bookId: number) => {
        await BookApi.removeFromWishlist(bookId);
        setBooks(prev => prev.filter(b => b.id !== bookId));
    };

    if (loading) return <LoadingSpinner />;
    if (error) return <ErrorMessage message={error} />;

    return (
        <>


            {books.length === 0 ? (
                <Box sx={{ textAlign: 'center', mt: 6 }}>
                    <Typography variant="h6" color="text.secondary">
                        Your wishlist is empty.
                    </Typography>
                </Box>
            ) : (
                <Grid container spacing={3}>
                    {books.map((book) => (
                        <Grid size={{ xs: 12, sm: 6, md: 4 }} key={book.id}>
                            <EntityCard
                                title={book.title}
                                navigateTo={`/books/${book.id}`}
                                extraActions={
                                    <IconButton
                                        size="small"
                                        color="error"
                                        onClick={() => handleRemove(book.id)}
                                    >
                                        <FavoriteIcon fontSize="small" />
                                    </IconButton>
                                }
                                fields={[
                                    { label: 'Category', value: book.category, chip: true },
                                    { label: 'Author', value: `${book.author?.name} ${book.author?.surname}` },
                                    { label: 'State', value: book.bookState, chip: true },
                                    { label: 'Available Copies', value: book.availableCopies },
                                ]}
                            />
                        </Grid>
                    ))}
                </Grid>
            )}
        </>
    );
};

export default WishlistPage;