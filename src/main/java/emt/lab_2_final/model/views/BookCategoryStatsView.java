package emt.lab_2_final.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Entity
@Data
@Immutable
@Table(name = "book_category_stats")
public class BookCategoryStatsView {
    @Id
    private String category;

    private Long totalBooks;
    private Long totalAvailableCopies;
    private Long notGoodBooks;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getTotalBooks() {
        return totalBooks;
    }

    public void setTotalBooks(Long totalBooks) {
        this.totalBooks = totalBooks;
    }

    public Long getTotalAvailableCopies() {
        return totalAvailableCopies;
    }

    public void setTotalAvailableCopies(Long totalAvailableCopies) {
        this.totalAvailableCopies = totalAvailableCopies;
    }

    public Long getNotGoodBooks() {
        return notGoodBooks;
    }

    public void setNotGoodBooks(Long notGoodBooks) {
        this.notGoodBooks = notGoodBooks;
    }
}
