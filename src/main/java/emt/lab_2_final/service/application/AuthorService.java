package emt.lab_2_final.service.application;


import emt.lab_2_final.model.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<DisplayAuthorDto> findAllAuthors();
    Optional<DisplayAuthorDto> findAuthorById(Long id);

}
