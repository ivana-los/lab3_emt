package emt.lab_2_final.repository;


import emt.lab_2_final.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
