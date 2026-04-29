import { Outlet } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import { Container } from "@mui/material";

export default function Layout() {
    return (
        <>
            <Header />
            <Container sx={{ mt: 4 }}>
                <Outlet />
            </Container>
            <Footer />
        </>
    );
}