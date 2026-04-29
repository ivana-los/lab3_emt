package emt.lab_2_final.model.projections;


import emt.lab_2_final.model.enums.BookState;
import emt.lab_2_final.model.enums.Category;

public interface BookShortProjection {
    Long getId();
    String getTitle();
    Category getCategory();

    BookState getBookState() ;
    //@Column(name = "available_copies")
    Integer getAvailableCopies();
}
