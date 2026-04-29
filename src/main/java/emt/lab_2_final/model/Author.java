package emt.lab_2_final.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Author extends BaseAuditableEntity {
    private String name;
    private String surname;

    @ManyToOne
    private Country country;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Country getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
