package emt.lab_2_final.service.application;


import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.dto.BookCreateDto;
import emt.lab_2_final.model.dto.DisplayBookDto;
import emt.lab_2_final.model.projections.BookDetailsProjection;
import emt.lab_2_final.model.projections.BookShortProjection;
import org.springframework.data.domain.Page;

import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<DisplayBookDto> findAll();
    Optional<DisplayBookDto> save(BookCreateDto bookCreateDto);
    Optional<DisplayBookDto> update(Long id, BookCreateDto bookCreateDto);
    void delete (Long id);
    Book rent (Long id);

    Page<DisplayBookDto> findAll(int page, int size, String sortBy);

    List<BookShortProjection> findAllShort();
    List<BookDetailsProjection> findAllDetails();

    List<Book> getAllBooksWithAuthorAndCountry();
    List<DisplayBookDto> findTop10Newest();

    Optional<DisplayBookDto> findById(Long id);

}
