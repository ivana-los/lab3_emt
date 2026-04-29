package emt.lab_2_final.model.dto;


import emt.lab_2_final.model.Author;
import emt.lab_2_final.model.Country;

import java.util.List;

public record DisplayAuthorDto(
        Long id,
        String name,
        String surname,
        String countryName,
        String continent
) {

    public static DisplayAuthorDto from(Author author) {
        Country country = author.getCountry();
        return new DisplayAuthorDto(
                author.getId(),
                author.getName(),
                author.getSurname(),
                country != null ? country.getName() : null,
                country != null ? country.getContinent() : null
        );
    }

    public static List<DisplayAuthorDto> from(List<Author> authors) {
        return authors.stream()
                .map(DisplayAuthorDto::from)
                .toList();
    }
}
