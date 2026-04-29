package emt.lab_2_final.model.exeptions;

public class AuthorNotFoundException extends RuntimeException {

    public AuthorNotFoundException(Integer id) {
        super("Author with id " + id + " was not found.");
    }
}