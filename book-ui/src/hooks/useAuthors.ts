import { useEffect, useState } from "react";
import { getAuthors } from "../api/authorsRepository";

export const useAuthors = () => {
    const [authors, setAuthors] = useState<any[]>([]);

    useEffect(() => {
        getAuthors()
            .then((res) => setAuthors(res.data))
            .catch((err) => console.error(err));
    }, []);

    return authors;
};