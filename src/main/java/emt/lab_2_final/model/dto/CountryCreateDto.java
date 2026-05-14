package emt.lab_2_final.model.dto;

import emt.lab_2_final.model.Country;
import jakarta.validation.constraints.NotNull;

public record CountryCreateDto (
        @NotNull
        String name,
        @NotNull
        String continent
){
    public Country toCountry() {
        Country country = new Country();
        country.setName(name);
        country.setContinent(continent);
        return country;
    }
}