package emt.lab_2_final.repository;


import emt.lab_2_final.model.views.BookCategoryStatsView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryStatsViewRepository
        extends JpaRepository<BookCategoryStatsView, String> {

}