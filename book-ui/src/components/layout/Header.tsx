import { AppBar, Toolbar, Button } from "@mui/material";
import { Link } from "react-router-dom";

export default function Header() {
    return (
        <AppBar position="static">
            <Toolbar>
                <Button color="inherit" component={Link} to="/">Home</Button>
                <Button color="inherit" component={Link} to="/books">Books</Button>
                <Button color="inherit" component={Link} to="/authors">Authors</Button>
                <Button color="inherit" component={Link} to="/countries">Countries</Button>
            </Toolbar>
        </AppBar>
    );
}