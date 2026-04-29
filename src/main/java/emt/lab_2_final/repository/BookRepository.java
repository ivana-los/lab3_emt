package emt.lab_2_final.repository;


import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.enums.BookState;
import emt.lab_2_final.model.enums.Category;
import emt.lab_2_final.model.projections.BookDetailsProjection;
import emt.lab_2_final.model.projections.BookShortProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByCategory(Category category, Pageable pageable);
    Page<Book> findByBookState(BookState bookState, Pageable pageable);
    Page<Book> findByAuthor_NameContaining(String author, Pageable pageable);
    Page<Book> findByAvailableCopiesGreaterThan(int primerociBr, Pageable pageable);

    List<BookShortProjection> findAllBy();
    @Query("""
        SELECT b.id AS id,
               b.title AS title,
               b.category AS category,
               b.bookState AS bookState,
               b.availableCopies AS availableCopies,
               a AS author
        FROM Book b
        JOIN b.author a
    """)
    List<BookDetailsProjection> findAllDetailedBy();

    @EntityGraph(value = "book-author-country-graph", type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT b FROM Book b")
    List<Book> findAllWithAuthorAndCountry();

    List<Book> findTop10ByOrderByDatePublishedDesc();
}
