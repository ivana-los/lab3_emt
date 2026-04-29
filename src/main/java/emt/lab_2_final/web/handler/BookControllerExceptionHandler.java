package emt.lab_2_final.web.handler;


import emt.lab_2_final.model.exeptions.BookNotFoundException;
import emt.lab_2_final.model.exeptions.NoAvailableCopiesException;
import emt.lab_2_final.web.BookController;
import emt.lab_2_final.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = BookController.class)
public class BookControllerExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ApiError> handleBookNotFound(BookNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(NoAvailableCopiesException.class)
    public ResponseEntity<ApiError> handleNoAvailableCopies(NoAvailableCopiesException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiError.of(HttpStatus.BAD_REQUEST, exception.getMessage()));
    }

}
