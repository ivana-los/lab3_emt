import axios from "./axios";

export const getAuthors = () => axios.get("/authors");