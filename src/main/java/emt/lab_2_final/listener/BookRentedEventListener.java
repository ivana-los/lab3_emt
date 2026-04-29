package emt.lab_2_final.listener;



import emt.lab_2_final.events.BookRentedEvent;
import emt.lab_2_final.model.Book;
import emt.lab_2_final.model.enums.EventType;
import emt.lab_2_final.service.application.ActivityLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@RequiredArgsConstructor
public class BookRentedEventListener {

    private final ActivityLogService activityLogService;

    @EventListener
    public void handle(BookRentedEvent event) {
        Book book = event.book();

        log.info("Book rented: {}", book.getTitle());

        if (book.getAvailableCopies() == 0) {
            log.warn("Book '{}' is OUT OF STOCK!", book.getTitle());
        }
        activityLogService.log(book.getTitle(), EventType.BOOK_RENTED);
    }
}