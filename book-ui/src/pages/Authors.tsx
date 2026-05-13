import { Grid, Box, Button } from '@mui/material';
import { useState } from 'react';
import useAuthors from "../hooks/useAuthors.ts";
import type { Author, AuthorFormData } from "../api/types/author.ts"; // 1. еден извор
import LoadingSpinner from "../components/layout/LoadingSpinner.tsx";
import ErrorMessage from "../components/layout/ErrorMessage.tsx";
import Header from "../components/layout/Header.tsx";
import AddAuthorDialog from "../components/product/AddAuthorDialog.tsx";
import EditAuthorDialog from "../components/product/EditAuthorDialog.tsx";
import DeleteAuthorDialog from "../components/product/DeleteAuthorDialog.tsx";
import EntityCard from "../components/layout/EntityCard.tsx";

const Authors = () => {
    const { authors, loading, error, onAdd, onEdit, onDelete } = useAuthors();
    const [openAdd, setOpenAdd] = useState(false);
    const [authorToEdit, setAuthorToEdit] = useState<Author | null>(null);
    const [authorToDelete, setAuthorToDelete] = useState<Author | null>(null);

    if (loading) return <LoadingSpinner />;
    if (error) return <ErrorMessage message={error} />;

    const handleAdd = async (data: AuthorFormData) => {
        await onAdd(data);
        setOpenAdd(false);
    };

    const handleEdit = async (id: number, data: AuthorFormData) => {
        await onEdit(id, data);
        setAuthorToEdit(null);
    };

    const handleDelete = async (id: number) => {
        await onDelete(id);
        setAuthorToDelete(null);
    };

    return (
        <>
            <Header title="Authors" subtitle={`Total: ${authors.length} authors`} />

            {/* 2. Add копче надвор од Header */}
            <Box sx={{ display: 'flex', justifyContent: 'flex-end', mb: 2 }}>
                <Button variant="contained" onClick={() => setOpenAdd(true)}>Add Author</Button>
            </Box>

            <AddAuthorDialog open={openAdd} onClose={() => setOpenAdd(false)} onAdd={handleAdd} />

            {authorToEdit && (
                <EditAuthorDialog
                    author={authorToEdit}
                    open={!!authorToEdit}
                    onClose={() => setAuthorToEdit(null)}
                    onEdit={handleEdit}
                />
            )}

            {authorToDelete && (
                <DeleteAuthorDialog
                    author={authorToDelete}
                    open={!!authorToDelete}
                    onClose={() => setAuthorToDelete(null)}
                    onDelete={handleDelete}
                />
            )}

            <Grid container spacing={3}>
                {authors.map((author) => (
                    <Grid size={{ xs: 12, sm: 6, md: 4 }} key={author.id}> {/* 3. item xs/sm/md -> size */}
                        <EntityCard
                            title={`${author.name} ${author.surname}`}
                            navigateTo={`/authors/${author.id}`}
                            onEdit={() => setAuthorToEdit(author)}
                            onDelete={() => setAuthorToDelete(author)}
                            fields={[
                                { label: 'Country', value: author.countryName },
                                { label: 'Continent', value: author.continent },
                            ]}
                        />
                    </Grid>
                ))}
            </Grid>
        </>
    );
};

export default Authors;