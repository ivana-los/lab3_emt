package emt.lab_2_final.service.application.impl;


import emt.lab_2_final.model.Author;
import emt.lab_2_final.model.Country;
import emt.lab_2_final.model.dto.AuthorCreateDto;
import emt.lab_2_final.model.dto.DisplayAuthorDto;
import emt.lab_2_final.repository.AuthorRepository;
import emt.lab_2_final.repository.CountryRepository;
import emt.lab_2_final.service.application.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
   private final CountryRepository countryRepository;
    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<DisplayAuthorDto> findAllAuthors() {
        return DisplayAuthorDto.from(authorRepository.findAll());
    }

    @Override
    public Optional<DisplayAuthorDto> findAuthorById(Long id) {
        return authorRepository.findById(id).map(DisplayAuthorDto::from);
    }
    @Override
    public Optional<DisplayAuthorDto> save(AuthorCreateDto authorCreateDto) {
        Country country = countryRepository.findById(authorCreateDto.countryId()).orElse(null);
        Author author = authorCreateDto.toAuthor(country);
        return Optional.of(DisplayAuthorDto.from(authorRepository.save(author)));
    }

    @Override
    public Optional<DisplayAuthorDto> update(Long id,AuthorCreateDto authorCreateDto) {
        Author author = authorRepository.findById(id).orElse(null);
        Country country = countryRepository.findById(authorCreateDto.countryId()).orElse(null);
        author.setName(authorCreateDto.name());
        author.setSurname(authorCreateDto.surname());
        author.setCountry(country);
        return Optional.of(DisplayAuthorDto.from(authorRepository.save(author)));
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
}
