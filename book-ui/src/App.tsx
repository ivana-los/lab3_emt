import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import Books from './pages/Books';
import Countries from './pages/Countries';
import Authors from './pages/Authors';
import BookDetails from './pages/BookDetails';
import AuthorDetails from './pages/AuthorsDetails';
import CountryDetails from './pages/CountryDitails';
import Login from './pages/Login';
import Register from './pages/Register';

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route element={<Layout />}>
                    <Route path="/" element={<Home />} />
                    <Route path="/books" element={<Books />} />
                    <Route path="/books/:id" element={<BookDetails />} />
                    <Route path="/authors" element={<Authors />} />
                    <Route path="/authors/:id" element={<AuthorDetails />} />
                    <Route path="/countries" element={<Countries />} />
                    <Route path="/countries/:id" element={<CountryDetails />} />
                    <Route path="/login" element={<Login />} />
                    <Route path="/register" element={<Register />} />
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default App;