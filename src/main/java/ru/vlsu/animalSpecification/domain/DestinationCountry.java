package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Destination_country")
public class DestinationCountry implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "country_name")
    private String countryName; // название страны (русское)

    @Column (name = "country_name_ENG")
    private String countryNameENG; // название страны (английское)

    @Column (name = "region")
    private long region; // регион Region.class

    @Column (name = "ISO_code")
    private String ISO_code; // https://ru.wikipedia.org/wiki/ISO_3166-1_alpha-2

    @Column (name = "region_of_the_country")
    private String region_of_the_country; // регион внутри страны (русское)

    @Column (name = "region_of_the_country_ENG")
    private String region_of_the_country_ENG; // регион внутри страны (английское)

    public DestinationCountry() { }

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryNameENG() {
        return countryNameENG;
    }

    public void setCountryNameENG(String countryNameENG) {
        this.countryNameENG = countryNameENG;
    }

    public long getRegion() {
        return region;
    }

    public void setRegion(long region) {
        this.region = region;
    }

    public String getISO_code() {
        return ISO_code;
    }

    public void setISO_code(String ISO_code) {
        this.ISO_code = ISO_code;
    }

    public String getRegion_of_the_country() {
        return region_of_the_country;
    }

    public void setRegion_of_the_country(String region_of_the_country) {
        this.region_of_the_country = region_of_the_country;
    }

    public String getRegion_of_the_country_ENG() {
        return region_of_the_country_ENG;
    }

    public void setRegion_of_the_country_ENG(String region_of_the_country_ENG) {
        this.region_of_the_country_ENG = region_of_the_country_ENG;
    }
}
