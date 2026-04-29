import { Typography, Button } from "@mui/material";
import { Link } from "react-router-dom";

export default function Home() {
    return (
        <>
            <Typography variant="h3">Welcome to Library</Typography>
            <Button variant="contained" component={Link} to="/books" sx={{ mt: 2 }}>
                View Books
            </Button>
        </>
    );
}