import { Box, Button, Grid, Paper, Typography } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const sections = [
    { title: 'Books', description: 'Browse all available books for rent.', path: '/books' },
    { title: 'Authors', description: 'Meet the authors of the books in the library.', path: '/authors' },
    { title: 'Countries', description: 'Explore which countries the authors come from.', path: '/countries' },
];

const Home = () => {
    const navigate = useNavigate();

    return (
        <>

            <Box sx={{ textAlign: 'center', py: 6 }}>
                <Typography variant="h3" sx={{ mb: 6, color: '#e5e4e7' }}>
                    Welcome to our Library
                </Typography>
                <Typography variant="h6" sx={{ mb: 6, color: '#e5e4e7' }}>
                    Your digital library for renting books
                </Typography>

                <Grid container spacing={4} sx={{ justifyContent: 'center' }}>
                    {sections.map((section) => (
                        <Grid size={{ xs: 12, sm: 6, md: 4 }} key={section.title}>
                            <Paper elevation={3} sx={{ p: 4, borderRadius: 2, height: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center', gap: 2 }}>
                                <Typography variant="h5" sx={{ mb: 6, color: '#e5e4e7' }}>{section.title}</Typography>
                                <Typography variant="body2" color="text.secondary" textAlign="center">
                                    {section.description}
                                </Typography>
                                <Button variant="contained" onClick={() => navigate(section.path)} sx={{ mt: 'auto' }}>
                                    Overview
                                </Button>
                            </Paper>
                        </Grid>
                    ))}
                </Grid>
            </Box>
        </>
    );
};

export default Home;