package ru.vlsu.animalSpecification.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private static final Logger log = Logger.getLogger(HomeController.class);

    @GetMapping("/index")
    public String toIndex() {
        log.debug("Request to go Index");
        return "index";
    }

    @GetMapping("/account")
    public String toAccount(){
        return "account/account";
    }

    @GetMapping("/auth")
    public String toAuthentificarion (){
        log.debug("Request to AUTH");
        return "account/authentification";
    }

    @GetMapping("/request/create")
    public String toCreateRequest(){
        log.debug("Request to create request");
        return "create_request/create-request";
    }

    @GetMapping("/request/done")
    public String toDoteRequest(){
        log.debug("Request to done request by User");
        return "create_request/request-done";
    }

    @GetMapping("/request/add-vakcination")
    public String toAddVakcinanion(){
        log.debug("Request to add Vakcination");
        return "create_request/add-vakcination";
    }

    @GetMapping("/animal/create")
    public String toCreateAnimal() {
        log.debug("Request to Create Animal");
        return "create_request/create-animal";
    }

    @GetMapping("/request/add-information")
    public String toAddInformation() {
        log.debug("Request to Add Information");
        return "create_request/add-information";
    }

    @GetMapping("/account/animal/info")
    public String toAnimalInfo(){
        log.debug("Request to view Animal Info");
        return "account/aboutAnimal";
    }

    @GetMapping("/account/animal")
    public String toAnimals() {
        log.debug("Request to view Animals");
        return "account/myAnimals";
    }

    @GetMapping("/account/vet")
    public String toVetAccount() {
        log.debug("Request to Vet Account");
        return "veterinarian_account/account";
    }

    @GetMapping("/request/vet/done")
    public String toDoneRequestVet() {
        log.debug("Request to Done request by Veterinar");
        return "veterinarian_account/request-done";
    }
}
