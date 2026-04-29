package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.model.Author;
import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.dto.BookCreateDto;
import emt.lab_2_final.model.dto.DisplayBookDto;
import emt.lab_2_final.model.exeptions.AuthorNotFoundException;
import emt.lab_2_final.model.exeptions.BookNotFoundException;
import emt.lab_2_final.model.projections.BookDetailsProjection;
import emt.lab_2_final.model.projections.BookShortProjection;
import emt.lab_2_final.repository.AuthorRepository;
import emt.lab_2_final.repository.BookRepository;
import emt.lab_2_final.service.application.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;





@Service

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<DisplayBookDto> findAll() {
        return DisplayBookDto.from(bookRepository.findAll());
    }


    @Override
    public Optional<DisplayBookDto> save(BookCreateDto dto) {

        Author author = authorRepository
                .findById(Long.valueOf(dto.authorId()))
                .orElse(null);

        if (author == null) {
            return Optional.empty();
        }

        Book book = bookRepository.save(dto.toBook(author));

        return Optional.of(DisplayBookDto.from(book));
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, BookCreateDto createBookDto) {

        Author author = authorRepository
                .findById(Long.valueOf(createBookDto.authorId()))
                .orElseThrow(() -> new AuthorNotFoundException(Math.toIntExact(createBookDto.authorId())));

        return bookRepository
                .findById(id)
                .map(book -> {
                    book.setTitle(createBookDto.name());
                    book.setCategory(createBookDto.category());
                    book.setAuthor(author);
                    book.setAvailableCopies(createBookDto.availableCopies());
                    book.setDatePublished(createBookDto.datePublished());
                    return bookRepository.save(book);
                })
                .map(DisplayBookDto::from);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(book);
    }

    @Override
    public Book rent(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        if (book.getAvailableCopies() > 0) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }
        return bookRepository.save(book);
    }

    @Override
    public Page<DisplayBookDto> findAll(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy).ascending()
        );

        return bookRepository.findAll(pageable)
                .map(DisplayBookDto::from);
    }

    @Override
    public List<BookShortProjection> findAllShort() {
        return bookRepository.findAllBy();
    }

    @Override
    public List<BookDetailsProjection> findAllDetails() {
        return bookRepository.findAllDetailedBy();
    }

    @Override
    public List<Book> getAllBooksWithAuthorAndCountry() {
        return bookRepository.findAllWithAuthorAndCountry();
    }

    @Override
    public List<DisplayBookDto> findTop10Newest() {
        return DisplayBookDto.from(
                bookRepository.findTop10ByOrderByDatePublishedDesc()
        );
    }
}
