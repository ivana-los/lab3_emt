import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AuthProvider from './providers/authProvider';
import RegisterPage from "./pages/Register.tsx";
import LoginPage from './pages/Login.tsx';
import Layout from './components/layout/Layout.tsx';
import { Home } from '@mui/icons-material';
import ProtectedRoute from "./components/routing/ProtectedRoute/ProtectedRoute.tsx";
import Books from "./pages/Books.tsx";
import BookDetails from "./pages/BookDetails.tsx";
import Authors from "./pages/Authors.tsx";
import AuthorDetails from "./pages/AuthorsDetails.tsx";
import Countries from "./pages/Countries.tsx";
import CountryDetail from "./pages/CountryDitails.tsx";
import WishlistPage from "./pages/Wishlist.tsx";

function App() {
    return (
        <AuthProvider>
            <BrowserRouter>
                <Routes>
                    <Route path='/register' element={<RegisterPage/>}/>
                    <Route path='/login' element={<LoginPage/>}/>
                    <Route element={<Layout />}>
                        <Route path="/" element={<Home />} />
                        <Route element={<ProtectedRoute/>}>
                            <Route path="/books" element={<Books />} />
                            <Route path="/books/:id" element={<BookDetails />} />
                            <Route path="/authors" element={<Authors />} />
                            <Route path="/authors/:id" element={<AuthorDetails />} />
                            <Route path="/countries" element={<Countries />} />
                            <Route path="/countries/:id" element={<CountryDetail />} />
                            <Route path="/wishlist" element={<WishlistPage />} />
                        </Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </AuthProvider>
    );
}

export default App;