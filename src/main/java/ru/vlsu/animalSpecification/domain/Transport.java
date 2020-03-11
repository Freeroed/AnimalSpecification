package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Transport")
public class Transport implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "transport_name")
    private String transportName;

    @Column (name = "transport_name_ENG")
    private String transportNameENG;

    @Override
    public String toString() {
        return "Transport{" +
                "transportName='" + transportName + '\'' +
                ", transportNameENG='" + transportNameENG + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransportName() {
        return transportName;
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportNameENG() {
        return transportNameENG;
    }

    public void setTransportNameENG(String transportNameENG) {
        this.transportNameENG = transportNameENG;
    }
}
