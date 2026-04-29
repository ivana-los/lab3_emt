import { useAuthors } from "../hooks/useAuthors";

const Authors = () => {
    const authors = useAuthors();

    return (
        <div>
            <h1>Authors</h1>
            {authors.map((a: any) => (
                <div key={a.id}>{a.name}</div>
            ))}
        </div>
    );
};

export default Authors;