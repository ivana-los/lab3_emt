package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.events.BookRentedEvent;
import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.BookCopy;
import emt.lab_2_final.model.dto.DisplayBookCopyDto;
import emt.lab_2_final.repository.BookCopyRepository;
import emt.lab_2_final.repository.BookRepository;
import emt.lab_2_final.service.application.BookCopyService;
import jakarta.transaction.Transactional;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCopyServiceImpl implements BookCopyService {

    private final BookCopyRepository bookCopyRepository;
    private final BookRepository bookRepository;
    private final ApplicationEventPublisher eventPublisher;

    public BookCopyServiceImpl(BookCopyRepository bookCopyRepository, BookRepository bookRepository, ApplicationEventPublisher eventPublisher) {
        this.bookCopyRepository = bookCopyRepository;
        this.bookRepository = bookRepository;
        this.eventPublisher = eventPublisher;
    }


    @Override
    public List<DisplayBookCopyDto> listAll() {
        return DisplayBookCopyDto.from(bookCopyRepository.findAll());
    }

    @Override
    public Optional<BookCopy> findById(Long id) {
        return bookCopyRepository.findById(id);
    }


    @Transactional
    public boolean rentCopy(Long copyId) {
        BookCopy copy = bookCopyRepository.findById(copyId)
                .orElseThrow(() -> new RuntimeException("Book copy not found"));
        if (copy.getRented()) {
            return false;
        }
        copy.setRented(true);
        bookCopyRepository.save(copy);

        Book book = copy.getBook();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        bookRepository.save(book);

        eventPublisher.publishEvent(new BookRentedEvent(book));
        return true;
    }

    @Transactional
    public void returnCopy(Long copyId) {
        BookCopy copy = bookCopyRepository.findById(copyId)
                .orElseThrow(() -> new RuntimeException("Book copy not found"));

        if (!copy.getRented()) {
            return;
        }
        copy.setRented(false);
        bookCopyRepository.save(copy);

        Book book = copy.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
        bookRepository.save(book);
    }
}
