package emt.lab_2_final.repository;


import emt.lab_2_final.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
