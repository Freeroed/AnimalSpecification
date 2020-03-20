package ru.vlsu.animalSpecification.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Request")
public class Request implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "animal")
    private long animal; // список жвотных в заявке (ну типа)

    @Column (name = "recipient")
    private long recipient; // получатель - id человека

    @Column (name = "destination_country")
    private long destinationCountry; // страна назначения (id)

    @Column (name = "border_crossing_point")
    private long borderCrossingPoint; // пункт пересечения границы (его id)

    @Column (name = "transport")
    private long transport; // тип транспорта (id)

    @Column (name = "vehicle_number")
    private String vehicleNumber; // номер автомобиля (если транпорт автомобитль, если самолет - мб номер самолета?)

    @Column (name = "veterinarian")
    private long veterinarian; // ветеринар, который выдаел сертификат 1

    @Column (name = "transaction_type")
    private String transactionType; // в примере - "перевозка без смены владельца" (серт.1 в меркурии)
                                    // возможно тут имеется в виду на продажу, на путешествие или как еще

    @Column (name = "way_of_storage_during_transportation")
    private String wayOfStorageDuringTransportation; // способ хранения при транспортировке (прим: вентилируемые)

    @Column (name = "quarantine_location")
    private String quarantineLocation; // место карантирования (прим: В домашних условиях)

    @Column (name = "number_of_days_to_quarantine")
    private int numberOfDaysToQuarantine; // колличесвто дней карантирования (прим: 30)

    @Column (name = "inspector_of_Rosselkhoznadzor")
    private long inspectorOfRosselkhoznadzor; // инспектор Р-а, выдавший сертиф. 5а / евросправку

    @Column (name = "postal_code")
    private String postalCode; // почтовый индекс грузополучателя для евросправки

    @Column (name = "date_of_departure")
    private Date dateOfDeparture; // дата отправления

    @Column (name = "certificate_1_form_number")
    private String certificate1FormNumber;  // Уникальный идентификатор ВСД

    @Column (name = "creator")
    private long creator;  // User создатель заявки

    /*
    Getters and Setters
    * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAnimal() {
        return animal;
    }

    public void setAnimal(long animal) {
        this.animal = animal;
    }

    public long getRecipient() {
        return recipient;
    }

    public void setRecipient(long recipient) {
        this.recipient = recipient;
    }

    public long getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(long destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public long getBorderCrossingPoint() {
        return borderCrossingPoint;
    }

    public void setBorderCrossingPoint(long borderCrossingPoint) {
        this.borderCrossingPoint = borderCrossingPoint;
    }

    public long getTransport() {
        return transport;
    }

    public void setTransport(long transport) {
        this.transport = transport;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public long getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(long veterinarian) {
        this.veterinarian = veterinarian;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getWayOfStorageDuringTransportation() {
        return wayOfStorageDuringTransportation;
    }

    public void setWayOfStorageDuringTransportation(String wayOfStorageDuringTransportation) {
        this.wayOfStorageDuringTransportation = wayOfStorageDuringTransportation;
    }

    public String getQuarantineLocation() {
        return quarantineLocation;
    }

    public void setQuarantineLocation(String quarantineLocation) {
        this.quarantineLocation = quarantineLocation;
    }

    public int getNumberOfDaysToQuarantine() {
        return numberOfDaysToQuarantine;
    }

    public void setNumberOfDaysToQuarantine(int numberOfDaysToQuarantine) {
        this.numberOfDaysToQuarantine = numberOfDaysToQuarantine;
    }

    public long getInspectorOfRosselkhoznadzor() {
        return inspectorOfRosselkhoznadzor;
    }

    public void setInspectorOfRosselkhoznadzor(long inspectorOfRosselkhoznadzor) {
        this.inspectorOfRosselkhoznadzor = inspectorOfRosselkhoznadzor;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Date getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Date dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getCertificate1FormNumber() {
        return certificate1FormNumber;
    }

    public void setCertificate1FormNumber(String certificate1FormNumber) {
        this.certificate1FormNumber = certificate1FormNumber;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }
}