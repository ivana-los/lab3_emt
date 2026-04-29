import { BrowserRouter, Routes, Route } from "react-router-dom";
import Layout from "./components/layout/Layout";
import Home from "./pages/Home";
import Books from "./pages/Books";
import Authors from "./pages/Authors";
import Countries from "./pages/Countries";

function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Layout />}>
            <Route index element={<Home />} />
            <Route path="books" element={<Books />} />
            <Route path="authors" element={<Authors />} />
            <Route path="countries" element={<Countries />} />
          </Route>
        </Routes>
      </BrowserRouter>
  );
}

export default App;