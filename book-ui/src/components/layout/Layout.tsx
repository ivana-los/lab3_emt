import { Outlet } from "react-router-dom";
import Header from "./Header";
import Footer from "./Footer";
import { Box, Container } from "@mui/material";

export default function Layout() {
    return (
        <Box sx={{ minHeight: '100vh', bgcolor: '#f5f5f5' }}>
            <Header />
            <Container sx={{ mt: 4, pb: 4 }}>
                <Outlet />
            </Container>
            <Footer />
        </Box>
    );
}