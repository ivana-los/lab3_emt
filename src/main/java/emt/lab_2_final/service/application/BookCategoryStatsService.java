package emt.lab_2_final.service.application;



import emt.lab_2_final.model.views.BookCategoryStatsView;

import java.util.List;

public interface BookCategoryStatsService {
    List<BookCategoryStatsView> getAllStats();
}