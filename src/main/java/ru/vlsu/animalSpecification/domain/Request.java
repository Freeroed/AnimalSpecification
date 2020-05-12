package ru.vlsu.animalSpecification.domain;

import ru.vlsu.animalSpecification.domain.emun.RequestStatus;
import ru.vlsu.animalSpecification.domain.emun.TransactionType;
import ru.vlsu.animalSpecification.domain.emun.TransportType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Request")
public class Request implements Serializable {

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
  @JoinColumn(name = "border_crossing_point", nullable = true)
  private BorderCrossingPoint borderCrossingPoint; // пункт пересечения границы

  @Enumerated(EnumType.STRING)
  @Column(name = "transport", nullable = true)
  private TransportType transport; // тип транспорта

  @Column (name = "vehicle_number")
  private String vehicleNumber; // номер автомобиля (если транпорт автомобитль, если самолет - мб номер самолета?)

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "veterinarian", nullable = true)
  private User veterinarian; // ветеринар, который выдаел сертификат 1

  @Enumerated(EnumType.STRING)
  @Column (name = "transaction_type")
  private TransactionType transactionType; // в примере - "перевозка без смены владельца" (серт.1 в меркурии)
  // возможно тут имеется в виду на продажу, на путешествие или как еще

  @Column (name = "way_of_storage_during_transportation")
  private String wayOfStorageDuringTransportation; // способ хранения при транспортировке (прим: вентилируемые)

  @Column (name = "quarantine_location")
  private String quarantineLocation; // место карантирования (прим: В домашних условиях)

  @Column (name = "number_of_days_to_quarantine")
  private Integer numberOfDaysToQuarantine; // колличесвто дней карантирования (прим: 30)

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "inspector_of_Rosselkhoznadzor", nullable = true)
  private User inspectorOfRosselkhoznadzor; // инспектор Р-а, выдавший сертиф. 5а / евросправку

  @Column (name = "postal_code")
  private String postalCode; // почтовый индекс грузополучателя для евросправки

  @Column (name = "date_of_departure")
  private Instant dateOfDeparture; // дата отправления

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "certificate_1_form_number", nullable = true)
  private Document certificate1FormNumber;  // Уникальный идентификатор ВСД

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name = "AnimalsInRequest", joinColumns = @JoinColumn(name = "request_id"),
    inverseJoinColumns = @JoinColumn(name = "animal_id"))
  private Set<Animal> animals = new HashSet<>();

  @Enumerated(EnumType.STRING)
  @Column (name = "status")
  private RequestStatus status; // статус заявки

  @Column(name="dateOfCreationa")
  private Instant createdAt;

  @Column(name="request_number")
  private String requestNumber;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "certificate_5a_form_number", nullable = true)
  private Document certificate5aFormNumber;  // Номер вет. сертификата 5а

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "certificate_euro_number", nullable = true)
  private Document  certificateEuroNumber;  // Номер евросправки

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public TransportType getTransport() {
    return transport;
  }

  public void setTransport(TransportType transport) {
    this.transport = transport;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public void setVehicleNumber(String vehicleNumber) {
    this.vehicleNumber = vehicleNumber;
  }

  public User getVeterinarian() {
    return veterinarian;
  }

  public void setVeterinarian(User veterinarian) {
    this.veterinarian = veterinarian;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
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

  public Integer getNumberOfDaysToQuarantine() {
    return numberOfDaysToQuarantine;
  }

  public void setNumberOfDaysToQuarantine(Integer numberOfDaysToQuarantine) {
    this.numberOfDaysToQuarantine = numberOfDaysToQuarantine;
  }

  public User getInspectorOfRosselkhoznadzor() {
    return inspectorOfRosselkhoznadzor;
  }

  public void setInspectorOfRosselkhoznadzor(User inspectorOfRosselkhoznadzor) {
    this.inspectorOfRosselkhoznadzor = inspectorOfRosselkhoznadzor;
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

  public Document getCertificate1FormNumber() {
    return certificate1FormNumber;
  }

  public void setCertificate1FormNumber(Document certificate1FormNumber) {
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Document getCertificate5aFormNumber() {
    return certificate5aFormNumber;
  }

  public void setCertificate5aFormNumber(Document certificate5aFormNumber) {
    this.certificate5aFormNumber = certificate5aFormNumber;
  }

  public Document getCertificateEuroNumber() {
    return certificateEuroNumber;
  }

  public void setCertificateEuroNumber(Document certificateEuroNumber) {
    this.certificateEuroNumber = certificateEuroNumber;
  }

  public String getRequestNumber() {
    return requestNumber;
  }

  public void setRequestNumber(String requestNumber) {
    this.requestNumber = requestNumber;
  }
}
