package emt.lab_2_final.service.application;


import emt.lab_2_final.model.dto.AuthorCreateDto;
import emt.lab_2_final.model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<DisplayAuthorDto> findAllAuthors();
    Optional<DisplayAuthorDto> findAuthorById(Long id);
    Optional<DisplayAuthorDto> save(AuthorCreateDto authorCreateDto);
    Optional<DisplayAuthorDto> update(Long id,AuthorCreateDto authorCreateDto);
    void delete(Long id);
}
