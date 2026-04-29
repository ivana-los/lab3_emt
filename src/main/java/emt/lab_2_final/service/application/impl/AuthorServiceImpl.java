package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.model.dto.DisplayAuthorDto;
import emt.lab_2_final.repository.AuthorRepository;
import emt.lab_2_final.service.application.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public List<DisplayAuthorDto> findAllAuthors() {
        return DisplayAuthorDto.from(authorRepository.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(DisplayAuthorDto::from);
    }
}
