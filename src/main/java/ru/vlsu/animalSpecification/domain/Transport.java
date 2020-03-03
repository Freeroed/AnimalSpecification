package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;

@Entity
@Table(name = "Transport")
public class Transport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "transport_name")
    private String transportName;

    @Column (name = "transport_name_ENG")
    private String transportNameENG;
}
