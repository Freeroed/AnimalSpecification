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
    private String ISOcode; // https://ru.wikipedia.org/wiki/ISO_3166-1_alpha-2

    @Column (name = "region_of_the_country")
    private String regionOfTheCountry; // регион внутри страны (русское)

    @Column (name = "region_of_the_country_ENG")
    private String regionOfTheCountryENG; // регион внутри страны (английское)

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

    public String getISOcode() {
      return ISOcode;
    }

    public void setISOcode(String ISOcode) {
      this.ISOcode = ISOcode;
    }

    public String getRegionOfTheCountry() {
      return regionOfTheCountry;
    }

    public void setRegionOfTheCountry(String regionOfTheCountry) {
      this.regionOfTheCountry = regionOfTheCountry;
    }

    public String getRegionOfTheCountryENG() {
      return regionOfTheCountryENG;
    }

    public void setRegionOfTheCountryENG(String regionOfTheCountryENG) {
      this.regionOfTheCountryENG = regionOfTheCountryENG;
    }
}
