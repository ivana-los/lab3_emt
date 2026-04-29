import axios from "./axios";

export const getBooks = () => axios.get("/books");
export const getBookById = (id: number) => axios.get(`/books/${id}`);