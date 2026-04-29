package emt.lab_2_final.service.application;



import emt.lab_2_final.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<DisplayCountryDto> findAll();
    Optional<DisplayCountryDto> findById(Long id);
}
