package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.model.dto.DisplayCountryDto;
import emt.lab_2_final.repository.CountryRepository;
import emt.lab_2_final.service.application.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @Override
    public List<DisplayCountryDto> findAll() {
        return DisplayCountryDto.from(countryRepository.findAll());
    }

    @Override
    public Optional<DisplayCountryDto> findById(Long id) {
        return countryRepository.findById(id).map(DisplayCountryDto::from);
    }
}
