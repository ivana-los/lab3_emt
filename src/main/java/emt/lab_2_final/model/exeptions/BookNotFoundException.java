package emt.lab_2_final.model.exeptions;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(Long id) {
        super("Book with id " + id + " was not found.");
    }
}