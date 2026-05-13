import { AppBar, Box, Button, Toolbar, Typography } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const navLinks = [
    { label: 'Books', path: '/books' },
    { label: 'Authors', path: '/authors' },
    { label: 'Countries', path: '/countries' },
];

const Navbar = () => {
    const navigate = useNavigate();

    return (
        <AppBar position="static">
            <Toolbar>
                <Typography
                    variant="h6"
                    sx={{ cursor: 'pointer', fontWeight: 700 }}
                    onClick={() => navigate('/')}
                >
                    Library
                </Typography>

                <Box sx={{ display: 'flex', gap: 1, ml: 4, flex: 1 }}>
                    {navLinks.map((link) => (
                        <Button key={link.label} color="inherit" onClick={() => navigate(link.path)}>
                            {link.label}
                        </Button>
                    ))}
                </Box>

                <Box sx={{ display: 'flex', gap: 1 }}>
                    <Button color="inherit" variant="outlined" onClick={() => navigate('/login')}>
                        Login
                    </Button>
                    <Button color="inherit" variant="contained" onClick={() => navigate('/register')}
                            sx={{ bgcolor: 'white', color: 'primary.main', '&:hover': { bgcolor: 'grey.100' } }}
                    >
                        Register
                    </Button>
                </Box>
            </Toolbar>
        </AppBar>
    );
};

export default Navbar;
