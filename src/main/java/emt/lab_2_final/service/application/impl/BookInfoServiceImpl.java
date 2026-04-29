package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.model.views.BookInfoView;
import emt.lab_2_final.repository.BookInfoViewRepository;
import emt.lab_2_final.service.application.BookInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {
    private final BookInfoViewRepository repository;

    public BookInfoServiceImpl(BookInfoViewRepository repository) {
        this.repository = repository;
    }


    public List<BookInfoView> getAllBookInfo() {
        return repository.findAll();
    }
}
