package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
/*
    Пункты пропуска смотреть тут: https://www.fsvps.ru/fsvps/importExport/tsouz/pvkp.html
*/
@Entity
@Table(name = "Border_crossing_point")
public class BorderCrossingPoint implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "location")
    private String location; // месторасположение

    @Column (name = "adjacent_point")
    private String adjacentPoint; // наименование сопредельного пункта пропуска

    @Column (name = "classification")
    private String classification; // классификация

    @Column (name = "schedule")
    private String schedule; // график работы пункта пропуска

    @Column (name = "schedule_of_management_officials")
    private String scheduleOfManagementOfficials; // график работы должностных лиц Управления

    /* Getters and Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAdjacentPoint() {
        return adjacentPoint;
    }

    public void setAdjacentPoint(String adjacentPoint) {
        this.adjacentPoint = adjacentPoint;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getScheduleOfManagementOfficials() {
        return scheduleOfManagementOfficials;
    }

    public void setScheduleOfManagementOfficials(String scheduleOfManagementOfficials) {
        this.scheduleOfManagementOfficials = scheduleOfManagementOfficials;
    }

    @Override
    public String toString() {
      return "BorderCrossingPoint{" +
        "id=" + id +
        ", location='" + location + '\'' +
        ", adjacentPoint='" + adjacentPoint + '\'' +
        ", classification='" + classification + '\'' +
        ", schedule='" + schedule + '\'' +
        ", scheduleOfManagementOfficials='" + scheduleOfManagementOfficials + '\'' +
        '}';
    }
}
