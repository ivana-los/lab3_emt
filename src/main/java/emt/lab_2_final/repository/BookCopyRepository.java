package emt.lab_2_final.repository;


import emt.lab_2_final.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {
}
