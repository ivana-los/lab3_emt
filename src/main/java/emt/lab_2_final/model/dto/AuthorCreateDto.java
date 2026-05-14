package emt.lab_2_final.model.dto;
import emt.lab_2_final.model.Author;
import emt.lab_2_final.model.Country;
import jakarta.validation.constraints.NotNull;

public record AuthorCreateDto(

        @NotNull
        String name,

        @NotNull
        String surname,

        Long countryId

) {
    public Author toAuthor(Country country) {
        Author author = new Author();
        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return author;
    }
}
