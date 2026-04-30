import { Grid } from '@mui/material';
import useBooks from '../hooks/useBooks';
import EntityCard from '../components/layout/EntityCard';
import LoadingSpinner from '../components/layout/LoadingSpinner';
import ErrorMessage from '../components/layout/ErrorMessage';
import Header from '../components/layout/Header';

const Books = () => {
    const { books, loading, error } = useBooks();

    if (loading) return <LoadingSpinner />;
    if (error) return <ErrorMessage message={error} />;

    return (
        <>
            <Header />
            <Grid container spacing={3}>
                {books.map((book) => (
                    <Grid  item xs={12} sm={6} md={4} key={book.id}>
                        <EntityCard
                            title={book.name}
                            navigateTo={`/books/${book.id}`}
                            fields={[
                                { label: 'Category', value: book.category, chip: true },
                                { label: 'Author', value: book.authorFullName },
                                { label: 'State', value: book.state, chip: true },
                                { label: 'BookCopies', value: book.availableCopies },
                            ]}
                        />
                    </Grid>
                ))}
            </Grid>
        </>
    );
};

export default Books;