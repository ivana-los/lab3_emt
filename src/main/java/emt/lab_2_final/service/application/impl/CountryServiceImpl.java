package emt.lab_2_final.service.application.impl;

import emt.lab_2_final.model.Country;
import emt.lab_2_final.model.dto.CountryCreateDto;
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
    @Override
    public Optional<DisplayCountryDto> save(CountryCreateDto countryCreateDto) {
        Country country = countryCreateDto.toCountry();
        return Optional.of(DisplayCountryDto.from(countryRepository.save(country)));
    }

    @Override
    public Optional<DisplayCountryDto> update(Long id, CountryCreateDto countryCreateDto) {
        Country country = countryRepository.findById(id).orElse(null);
        country.setName(countryCreateDto.name());
        country.setContinent(countryCreateDto.continent());
        return Optional.of(DisplayCountryDto.from(countryRepository.save(country)));
    }

    @Override
    public void deltete(Long id) {
        countryRepository.deleteById(id);
    }
}
