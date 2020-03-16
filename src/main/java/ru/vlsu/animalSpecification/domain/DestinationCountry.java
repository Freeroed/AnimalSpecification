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


}
