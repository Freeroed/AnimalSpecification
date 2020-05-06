package ru.vlsu.animalSpecification.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.vlsu.animalSpecification.domain.*;
import ru.vlsu.animalSpecification.domain.emun.RequestStatus;
import ru.vlsu.animalSpecification.domain.emun.TransactionType;
import ru.vlsu.animalSpecification.domain.emun.TransportType;
import ru.vlsu.animalSpecification.service.mapper.AnimalMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RequestDTO implements Serializable {

  private Long id;

  private UserDTO recipient; // получатель - человек

  private DestinationCountry destinationCountry; // СТРАНА назначения

  private String destinationCity; // ГОРОД назначения

  private BorderCrossingPoint borderCrossingPoint; // пункт пересечения границы

  private TransportType transport; // тип транспорта

  private String vehicleNumber; // номер автомобиля (если транпорт автомобитль, если самолет - мб номер самолета?)

  private UserDTO veterinarian; // ветеринар, который выдаел сертификат 1

  private TransactionType transactionType;

  private String wayOfStorageDuringTransportation; // способ хранения при транспортировке (прим: вентилируемые)

  private String quarantineLocation; // место карантирования (прим: В домашних условиях)

  private Integer numberOfDaysToQuarantine; // колличесвто дней карантирования (прим: 30)

  private UserDTO inspectorOfRosselkhoznadzor; // инспектор Р-а, выдавший сертиф. 5а / евросправку

  private String postalCode; // почтовый индекс грузополучателя для евросправки

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" ,timezone = "UTC")
  private Instant dateOfDeparture; // дата отправления

  private Document certificate1FormNumber;  // Уникальный идентификатор ВСД

  private Set<AnimalDTO> animals = new HashSet<>();

  private RequestStatus status; // статус заявки

  private Document certificateEuroNumber;

  public Document getCertificate5aFormNumber() {
    return certificate5aFormNumber;
  }

  public void setCertificate5aFormNumber(Document certificate5aFormNumber) {
    this.certificate5aFormNumber = certificate5aFormNumber;
  }

  private Document certificate5aFormNumber;  // Номер вет. сертификата 5а

  public Document getCertificateEuroNumber() {
    return certificateEuroNumber;
  }

  public void setCertificateEuroNumber(Document certificateEuroNumber) {
    this.certificateEuroNumber = certificateEuroNumber;
  }

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" ,timezone = "UTC")
  private Instant createdAt;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserDTO getRecipient() {
    return recipient;
  }

  public void setRecipient(UserDTO recipient) {
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

  public UserDTO getVeterinarian() {
    return veterinarian;
  }

  public void setVeterinarian(UserDTO veterinarian) {
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

  public UserDTO getInspectorOfRosselkhoznadzor() {
    return inspectorOfRosselkhoznadzor;
  }

  public void setInspectorOfRosselkhoznadzor(UserDTO inspectorOfRosselkhoznadzor) {
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

  public Set<AnimalDTO> getAnimals() {
    return animals;
  }

  public void setAnimals(Set<AnimalDTO> animals) {
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

  public RequestDTO(Request request) {
    this.id = request.getId();
    this.recipient = new UserDTO(request.getRecipient());
    this.destinationCountry = request.getDestinationCountry() != null ? request.getDestinationCountry() : null;
    this.destinationCity = request.getDestinationCity() != null ? request.getDestinationCity() : null;
    this.borderCrossingPoint = request.getBorderCrossingPoint() != null ? request.getBorderCrossingPoint() : null;
    this.transport = request.getTransport() != null ? request.getTransport() : null;
    this.vehicleNumber = request.getVehicleNumber() != null ? request.getVehicleNumber() : null;
    this.veterinarian =request.getVeterinarian() != null ? new UserDTO(request.getVeterinarian()) : null;
    this.transactionType = request.getTransactionType() != null ? request.getTransactionType() : null;
    this.wayOfStorageDuringTransportation = request.getWayOfStorageDuringTransportation() != null ? request.getWayOfStorageDuringTransportation() : null;
    this.quarantineLocation = request.getQuarantineLocation() != null ? request.getQuarantineLocation() : null;
    this.numberOfDaysToQuarantine = request.getNumberOfDaysToQuarantine() != null ? request.getNumberOfDaysToQuarantine() : null;
    this.inspectorOfRosselkhoznadzor = request.getInspectorOfRosselkhoznadzor() != null ? new UserDTO(request.getInspectorOfRosselkhoznadzor()) : null;
    this.postalCode = request.getPostalCode() != null ? request.getPostalCode() : null;
    this.dateOfDeparture = request.getDateOfDeparture() != null ? request.getDateOfDeparture() : null;
    this.certificate1FormNumber = request.getCertificate1FormNumber() != null ? request.getCertificate1FormNumber() : null;
    this.status = request.getStatus() != null ? request.getStatus() : null;
    this.createdAt = request.getCreatedAt() != null ? request.getCreatedAt() : null;
    this.certificate1FormNumber = request.getCertificate1FormNumber() != null ? request.getCertificate1FormNumber() : null;
    this.certificateEuroNumber = request.getCertificateEuroNumber()  != null ? request.getCertificateEuroNumber() : null;
    this.certificate5aFormNumber = request.getCertificate5aFormNumber() != null ? request.getCertificate5aFormNumber() : null;
  }

  @Override
  public String toString() {
    return "RequestDTO{" +
      "id=" + id +
      ", recipient=" + recipient +
      ", destinationCountry=" + destinationCountry +
      ", destinationCity='" + destinationCity + '\'' +
      ", borderCrossingPoint=" + borderCrossingPoint +
      ", transport=" + transport +
      ", vehicleNumber='" + vehicleNumber + '\'' +
      ", veterinarian=" + veterinarian +
      ", transactionType=" + transactionType +
      ", wayOfStorageDuringTransportation='" + wayOfStorageDuringTransportation + '\'' +
      ", quarantineLocation='" + quarantineLocation + '\'' +
      ", numberOfDaysToQuarantine=" + numberOfDaysToQuarantine +
      ", inspectorOfRosselkhoznadzor=" + inspectorOfRosselkhoznadzor +
      ", postalCode='" + postalCode + '\'' +
      ", dateOfDeparture=" + dateOfDeparture +
      ", certificate1FormNumber='" + certificate1FormNumber + '\'' +
      ", animals=" + animals +
      ", status=" + status +
      ", certificateEuroNumber='" + certificateEuroNumber + '\'' +
      ", certificate5aFormNumber='" + certificate5aFormNumber + '\'' +
      ", createdAt=" + createdAt +
      '}';
  }

  public RequestDTO() {
  }
}
