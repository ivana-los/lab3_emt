package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.model.views.BookCategoryStatsView;
import emt.lab_2_final.repository.BookCategoryStatsViewRepository;
import emt.lab_2_final.service.application.BookCategoryStatsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryStatsServiceImpl implements BookCategoryStatsService {

    private final BookCategoryStatsViewRepository repository;

    public BookCategoryStatsServiceImpl(BookCategoryStatsViewRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<BookCategoryStatsView> getAllStats() {
        return repository.findAll();
    }
}
