package emt.lab_2_final.model;

import emt.lab_2_final.model.enums.BookState;
import emt.lab_2_final.model.enums.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@NamedEntityGraph(
        name = "book-author-country-graph",
        attributeNodes = {
                @NamedAttributeNode(value = "author", subgraph = "author-country")
        },
        subgraphs = {
                @NamedSubgraph(
                        name = "author-country",
                        attributeNodes = @NamedAttributeNode("country")
                )
        }
)
@Getter
@Setter
public class Book extends BaseAuditableEntity {
    private String title;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private BookState bookState;

    @ManyToOne
    private Author author;

    @OneToMany(mappedBy = "book")
    private List<BookCopy> copies;

    private Integer availableCopies;

    @Column(name = "date_published")
    private LocalDate datePublished;


//    public String getName() {
//        return title;
//    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setBookState(BookState bookState) {
        this.bookState = bookState;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }


    public Category getCategory() {
        return category;
    }

    public BookState getBookState() {
        return bookState;
    }

    public Author getAuthor() {
        return author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }
}