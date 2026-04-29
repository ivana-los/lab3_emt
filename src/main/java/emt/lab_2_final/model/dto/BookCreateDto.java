package emt.lab_2_final.model.dto;


import emt.lab_2_final.model.Author;
import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.enums.BookState;
import emt.lab_2_final.model.enums.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookCreateDto(

        @NotNull
        String name,

        @NotNull
        Category category,

        Long authorId,

        @Min(0)
        Integer availableCopies,
        LocalDate datePublished


) {

    public Book toBook(Author author) {
        Book book = new Book();

        book.setTitle(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        book.setBookState(BookState.GOOD);
        book.setDatePublished(datePublished);
        return book;
    }
}