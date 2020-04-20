package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.service.RequestService;
import ru.vlsu.animalSpecification.service.dto.RequestDTO;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RequestResource {

    private static final Logger log = LoggerFactory.getLogger(RequestResource.class);


    private final RequestService requestService;

    private final HttpServletRequest httpServletRequest;

    @Autowired
    public RequestResource(RequestService requestService, HttpServletRequest httpServletRequest) {
      this.requestService = requestService;
      this.httpServletRequest = httpServletRequest;
    }


    @GetMapping("/requests/my")
    public  ResponseEntity getMyRequests(){
      String userName = httpServletRequest.getRemoteUser();
      log.debug("REST request to get all requests by user with userName : {}", userName);
      List<RequestDTO> result = requestService.findRequestByUser(userName);
      if (result != null) {
        return  ResponseEntity.ok().body(result);
      } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("USER WITH USERNAME " + userName + "NOT FOUND");
      }
    }
  // Можно удалить. Пока пусть будет для тестов
    @GetMapping("/requests")
    public List<RequestDTO> getAllRequests() {
      log.debug("REST request to get All requests");
      return  requestService.listAll();
    }

    // Добавить заявку
    @PostMapping("/requests")
    public ResponseEntity createRequest(@RequestBody RequestDTO request) throws URISyntaxException {
      String userName = httpServletRequest.getRemoteUser();
      log.debug("REST request to save request : {}, by user with userName : {}", request, userName);
      if (request.getId() != null) {
        return ResponseEntity.badRequest().build();
      } else {
        requestService.save(request, userName);
        return ResponseEntity.created(new URI("/request" ))
          .body(request);
      }
    }

    // Редактировать заявку
    @PutMapping("/requests")
    public ResponseEntity updateRequest(@RequestBody RequestDTO request) {
      String userName = httpServletRequest.getRemoteUser();
      log.debug("REST request to update request with id : {}, with userName : {}", request.getId(), userName);

      if (request.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        requestService.save(request, userName);
        return ResponseEntity.ok().body(request);
      }
    }

    // Удалить заявку
    @DeleteMapping("/requests/{id}")
    public ResponseEntity deleteRequest(@PathVariable Long id) {
      log.debug("REST request to delete request with id : {}", id);
      requestService.delete(id);
      return ResponseEntity.noContent().build();
    }

    @GetMapping("/requests/{id}")
    public ResponseEntity getRequest(@PathVariable Long id) {
      log.debug("REST request to get get Request by id : {}", id);
      Optional<RequestDTO> request = requestService.findOne(id);
      if(!request.equals(Optional.empty())) {
        return  ResponseEntity.ok().body(request);
      } else {
        return  ResponseEntity.notFound().build();
      }
    }
}
