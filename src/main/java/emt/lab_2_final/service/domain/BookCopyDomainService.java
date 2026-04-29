package emt.lab_2_final.service.domain;



import emt.lab_2_final.model.BookCopy;

import java.util.List;
import java.util.Optional;

public interface BookCopyDomainService {
    List<BookCopy> listAll();
    Optional<BookCopy> findById(Long id);
    BookCopy create(BookCopy bookCopy);
    BookCopy update(BookCopy bookCopy);
    void delete(Long id);


    void rentCopy(BookCopy bookCopy);
    void returnCopy(BookCopy bookCopy);
}
