import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { getBookById } from "../api/booksRepository";

export default function BookDetails() {
    const { id } = useParams();
    const [book, setBook] = useState<any>(null);

    useEffect(() => {
        getBookById(Number(id)).then((res) => setBook(res.data));
    }, [id]);

    if (!book) return <p>Loading...</p>;

    return (
        <div>
            <h2>{book.name}</h2>
            <p>{book.category}</p>
            <p>{book.availableCopies}</p>
        </div>
    );
}