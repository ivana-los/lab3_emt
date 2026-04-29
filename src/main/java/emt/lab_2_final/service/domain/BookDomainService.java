package emt.lab_2_final.service.domain;



import emt.lab_2_final.model.Book;

import java.util.List;
import java.util.Optional;

 public interface BookDomainService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book create(String title, String author);
    void delete(Long id);
    void rent(Book book);
}

