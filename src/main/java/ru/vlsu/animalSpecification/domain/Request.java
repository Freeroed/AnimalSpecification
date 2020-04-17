package ru.vlsu.animalSpecification.domain;

import ru.vlsu.animalSpecification.domain.emun.RequestStatus;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient", nullable = false)
    private User recipient; // получатель - человек

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_country", nullable = false)
    private DestinationCountry destinationCountry; // СТРАНА назначения

    @Column (name = "destination_city")
    private String destinationCity; // ГОРОД назначения

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "border_crossing_point", nullable = false)
    private BorderCrossingPoint borderCrossingPoint; // пункт пересечения границы

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transport", nullable = false)
    private Transport transport; // тип транспорта

    @Column (name = "vehicle_number")
    private String vehicleNumber; // номер автомобиля (если транпорт автомобитль, если самолет - мб номер самолета?)

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinarian", nullable = false)
    private User veterinarian; // ветеринар, который выдаел сертификат 1

    @Column (name = "transaction_type")
    private String transactionType; // в примере - "перевозка без смены владельца" (серт.1 в меркурии)
                                    // возможно тут имеется в виду на продажу, на путешествие или как еще

    @Column (name = "way_of_storage_during_transportation")
    private String wayOfStorageDuringTransportation; // способ хранения при транспортировке (прим: вентилируемые)

    @Column (name = "quarantine_location")
    private String quarantineLocation; // место карантирования (прим: В домашних условиях)

    @Column (name = "number_of_days_to_quarantine")
    private int numberOfDaysToQuarantine; // колличесвто дней карантирования (прим: 30)

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inspector_of_Rosselkhoznadzor", nullable = false)
    private User inspectorOfRosselkhoznadzor; // инспектор Р-а, выдавший сертиф. 5а / евросправку

    @Column (name = "postal_code")
    private String postalCode; // почтовый индекс грузополучателя для евросправки

    @Column (name = "date_of_departure")
    private Instant dateOfDeparture; // дата отправления

    @Column (name = "certificate_1_form_number")
    private String certificate1FormNumber;  // Уникальный идентификатор ВСД

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name = "AnimalsInRequest", joinColumns = @JoinColumn(name = "request_id"),
      inverseJoinColumns = @JoinColumn(name = "animal_id"))
    private Set<Animal> animals = new HashSet<>();

    @Enumerated(EnumType.STRING)
    @Column (name = "status")
    private RequestStatus status; // статус заявки

    /*
    Getters and Setters
    * */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Instant getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(Instant dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    public String getCertificate1FormNumber() {
        return certificate1FormNumber;
    }

    public void setCertificate1FormNumber(String certificate1FormNumber) {
        this.certificate1FormNumber = certificate1FormNumber;
    }

    public Set<Animal> getAnimals() {
      return animals;
    }

    public void setAnimals(Set<Animal> animals) {
      this.animals = animals;
    }

  public RequestStatus getStatus() {
    return status;
  }

  public void setStatus(RequestStatus status) {
    this.status = status;
  }

  public User getRecipient() {
    return recipient;
  }

  public void setRecipient(User recipient) {
    this.recipient = recipient;
  }

  public DestinationCountry getDestinationCountry() {
    return destinationCountry;
  }

  public void setDestinationCountry(DestinationCountry destinationCountry) {
    this.destinationCountry = destinationCountry;
  }

  public String getDestinationCity() {
    return destinationCity;
  }

  public void setDestinationCity(String destinationCity) {
    this.destinationCity = destinationCity;
  }

  public BorderCrossingPoint getBorderCrossingPoint() {
    return borderCrossingPoint;
  }

  public void setBorderCrossingPoint(BorderCrossingPoint borderCrossingPoint) {
    this.borderCrossingPoint = borderCrossingPoint;
  }

  public Transport getTransport() {
    return transport;
  }

  public void setTransport(Transport transport) {
    this.transport = transport;
  }

  public User getVeterinarian() {
    return veterinarian;
  }

  public void setVeterinarian(User veterinarian) {
    this.veterinarian = veterinarian;
  }

  public User getInspectorOfRosselkhoznadzor() {
    return inspectorOfRosselkhoznadzor;
  }

  public void setInspectorOfRosselkhoznadzor(User inspectorOfRosselkhoznadzor) {
    this.inspectorOfRosselkhoznadzor = inspectorOfRosselkhoznadzor;
  }

  @Override
    public String toString() {
      return "Request{" +
        "id=" + id +
        ", recipient=" + recipient +
        ", destinationCountry=" + destinationCountry +
        ", borderCrossingPoint=" + borderCrossingPoint +
        ", transport=" + transport +
        ", vehicleNumber='" + vehicleNumber + '\'' +
        ", veterinarian=" + veterinarian +
        ", transactionType='" + transactionType + '\'' +
        ", wayOfStorageDuringTransportation='" + wayOfStorageDuringTransportation + '\'' +
        ", quarantineLocation='" + quarantineLocation + '\'' +
        ", numberOfDaysToQuarantine=" + numberOfDaysToQuarantine +
        ", inspectorOfRosselkhoznadzor=" + inspectorOfRosselkhoznadzor +
        ", postalCode='" + postalCode + '\'' +
        ", dateOfDeparture=" + dateOfDeparture +
        ", certificate1FormNumber='" + certificate1FormNumber + '\'' +
        ", animals=" + animals +
        '}';
    }
}
