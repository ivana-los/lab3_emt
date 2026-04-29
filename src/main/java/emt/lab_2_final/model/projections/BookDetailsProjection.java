package emt.lab_2_final.model.projections;


import emt.lab_2_final.model.enums.BookState;
import emt.lab_2_final.model.enums.Category;

public interface BookDetailsProjection {
    Long getId();
    String getTitle();
    Category getCategory();
    BookState getBookState();
    //@Column(name = "available_copies")
    Integer getAvailableCopies();

    AuthorInfo getAuthor();
    interface AuthorInfo{
        String getName();
        String getSurname();
        CountryInfo getCountry();

        interface CountryInfo{
            String getName();
        }
    }
}
