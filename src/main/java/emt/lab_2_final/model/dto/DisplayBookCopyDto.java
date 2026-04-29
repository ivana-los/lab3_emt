package emt.lab_2_final.model.dto;



import emt.lab_2_final.model.BookCopy;

import java.util.List;

public record DisplayBookCopyDto(
        Long id,
        Long bookId,
        String bookTitle,
        Boolean rented
) {

    public static DisplayBookCopyDto from(BookCopy copy) {
        return new DisplayBookCopyDto(
                copy.getId(),
                copy.getBook().getId(),
                copy.getBook().getTitle(),
                copy.getRented()
        );
    }

    public static List<DisplayBookCopyDto> from(List<BookCopy> copies) {
        return copies.stream()
                .map(DisplayBookCopyDto::from)
                .toList();
    }
}
