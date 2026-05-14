package emt.lab_2_final.service.application;



import emt.lab_2_final.model.dto.CountryCreateDto;
import emt.lab_2_final.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
    Optional<DisplayCountryDto> save(CountryCreateDto countryCreateDto);
    Optional<DisplayCountryDto> update(Long id,CountryCreateDto countryCreateDto);
    void deltete(Long id);
}
