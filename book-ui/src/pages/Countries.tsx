import { useCountries } from "../hooks/useCountries";

const Countries = () => {
    const countries = useCountries();

    return (
        <div>
            <h1>Countries</h1>
            {countries.map((c: any) => (
                <div key={c.id}>{c.name}</div>
            ))}
        </div>
    );
};

export default Countries;