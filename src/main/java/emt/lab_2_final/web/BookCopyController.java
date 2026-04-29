package emt.lab_2_final.web;


import emt.lab_2_final.model.BookCopy;
import emt.lab_2_final.model.dto.DisplayBookCopyDto;
import emt.lab_2_final.service.application.BookCopyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-copies")
public class BookCopyController {
    private final BookCopyService bookCopyService;

    public BookCopyController(BookCopyService bookCopyService) {
        this.bookCopyService = bookCopyService;
    }
    @GetMapping
    public List<DisplayBookCopyDto> listAllCopies() {
        return bookCopyService.listAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookCopy> getCopy(@PathVariable Long id) {
        return bookCopyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping("/{id}/rent")
    public ResponseEntity<String> rentCopy(@PathVariable Long id) {
        boolean rented = bookCopyService.rentCopy(id);
        if (rented) {
            return ResponseEntity.ok("Book copy rented successfully.");
        } else {
            return ResponseEntity.badRequest().body("Book copy is already rented.");
        }
    }
    @PostMapping("/{id}/return")
    public ResponseEntity<String> returnCopy(@PathVariable Long id) {


        bookCopyService.returnCopy(id);
        return ResponseEntity.ok("Book copy returned successfully.");
    }
}
