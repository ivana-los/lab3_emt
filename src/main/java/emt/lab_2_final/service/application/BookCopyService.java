package emt.lab_2_final.service.application;



import emt.lab_2_final.model.BookCopy;
import emt.lab_2_final.model.dto.DisplayBookCopyDto;

import java.util.List;
import java.util.Optional;

public interface BookCopyService {
    List<DisplayBookCopyDto> listAll();
    Optional<BookCopy> findById(Long id);
    //    BookCopy create(BookCopy bookcopy);
//    BookCopy update(BookCopy bookcopy);
//    void delete(Long id);
    boolean rentCopy(Long copyId);
    void returnCopy(Long copyId);
}
