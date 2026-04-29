import { useBooks } from "../hooks/useBooks";
import { Grid, Card, CardContent, Typography } from "@mui/material";
import { Link } from "react-router-dom";

export default function Books() {
    // @ts-ignore
    const { books, loading } = useBooks();

    if (loading) return <p>Loading...</p>;

    return (
        <Grid container spacing={2}>
            {books.map((book: any) => (
                <Grid item xs={12} md={4} key={book.id}>
                    <Card component={Link} to={`/books/${book.id}`} sx={{ textDecoration: "none" }}>
                        <CardContent>
                            <Typography variant="h6">{book.name}</Typography>
                            <Typography variant="body2">{book.category}</Typography>
                        </CardContent>
                    </Card>
                </Grid>
            ))}
        </Grid>
    );
}