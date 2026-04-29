package emt.lab_2_final.model.views;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable

@Table(name = "book_info_view")
public class BookInfoView {

    @Id
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "book_title")
    private String bookTitle;
    @Column(name = "book_category")
    private String bookCategory;
    @Column(name = "book_state")
    private String bookState;
    @Column(name = "available_copies")
    private Integer availableCopies;
    @Column(name = "author_full_name")
    private String authorFullName;
    @Column(name = "country_name")
    private String countryName;


    public Long getBookId() { return bookId; }
    public String getBookTitle() { return bookTitle; }
    public String getBookCategory() { return bookCategory; }
    public String getBookState() { return bookState; }
    public Integer getAvailableCopies() { return availableCopies; }
    public String getAuthorFullName() { return authorFullName; }
    public String getCountryName() { return countryName; }
}