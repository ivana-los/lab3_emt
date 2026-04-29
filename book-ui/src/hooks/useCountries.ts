import { useEffect, useState } from "react";
import { getCountries } from "../api/countriesRepository";

export const useCountries = () => {
    const [countries, setCountries] = useState<any[]>([]);

    useEffect(() => {
        getCountries()
            .then((res) => setCountries(res.data))
            .catch((err) => console.error(err));
    }, []);

    return countries;
};