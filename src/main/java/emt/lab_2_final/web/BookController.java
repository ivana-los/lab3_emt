package emt.lab_2_final.web;

import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.dto.BookCreateDto;
import emt.lab_2_final.model.dto.DisplayBookDto;
import emt.lab_2_final.model.projections.BookDetailsProjection;
import emt.lab_2_final.model.projections.BookShortProjection;
import emt.lab_2_final.model.views.BookCategoryStatsView;
import emt.lab_2_final.model.views.BookInfoView;
import emt.lab_2_final.service.application.BookCategoryStatsService;
import emt.lab_2_final.service.application.BookInfoService;
import emt.lab_2_final.service.application.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    private final BookInfoService bookInfoService;
    private final BookCategoryStatsService bookCategoryStatsService;

    public BookController(BookService bookService, BookInfoService bookInfoService, BookCategoryStatsService bookCategoryStatsService) {
        this.bookService = bookService;

        this.bookInfoService = bookInfoService;
        this.bookCategoryStatsService = bookCategoryStatsService;
    }
    @GetMapping
    public ResponseEntity<List<DisplayBookDto>> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayBookDto> findById(@PathVariable Long id) {
        return bookService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayBookDto>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        return ResponseEntity.ok(
                bookService.findAll(page, size, sortBy)
        );
    }
    @GetMapping("/short")
    public List<BookShortProjection> getAllShort() {
        return bookService.findAllShort();
    }

    @GetMapping("/details")
    public List<BookDetailsProjection> getAllDetails() {
        return bookService.findAllDetails();
    }
    @GetMapping("/book-author-country-graph")
    public List<Book> getAllBooks() {
        return bookService.getAllBooksWithAuthorAndCountry();
    }
    @GetMapping("/book-info-view")
    public List<BookInfoView> getBookInfo() {
        return bookInfoService.getAllBookInfo();
    }
    @GetMapping("/books-stats")
    public List<BookCategoryStatsView> getBookStats() {
        return bookCategoryStatsService.getAllStats();
    }

    @GetMapping("/top10Newest")
    public List<DisplayBookDto> getTop10NewestBooks() {
        return bookService.findTop10Newest();
    }


    @PostMapping("/add")
    public ResponseEntity<DisplayBookDto> save(@RequestBody BookCreateDto bookCreateDto) {
        return bookService
                .save(bookCreateDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DisplayBookDto> update(
            @PathVariable Long id,
            @RequestBody BookCreateDto bookCreateDto
    ) {
        return bookService
                .update(id, bookCreateDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<DisplayBookDto> rent(@PathVariable Long id) {
        Book book = bookService.rent(id);
        return ResponseEntity.ok(DisplayBookDto.from(book));
    }

}