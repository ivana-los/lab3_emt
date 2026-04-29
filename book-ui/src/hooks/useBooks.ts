import { useEffect, useState } from "react";
import { getBooks } from "../api/booksRepository";

export const useBooks = () => {
    const [books, setBooks] = useState<any[]>([]);

    useEffect(() => {
        getBooks().then(res => setBooks(res.data));
    }, []);

    return books;
};