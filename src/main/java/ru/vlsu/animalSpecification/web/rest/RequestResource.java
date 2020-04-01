package ru.vlsu.animalSpecification.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.Vaccine;
import ru.vlsu.animalSpecification.service.RequestService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RequestResource {

    private static final Logger log = LoggerFactory.getLogger(RequestResource.class);

    @Autowired
    private RequestService requestService;

    // Можно удалить. Пока пусть будет для тестов
    @GetMapping("/requests")
    public List<Request> getAllRequests() {
        return  requestService.listAll();
    }

    // Добавить заявку
    @PostMapping("/request")
    public ResponseEntity createRequest(@RequestBody Request request) throws URISyntaxException {

      log.debug("REST request to save request : " + request);

      if (request.getId() != null) {
        return ResponseEntity.badRequest().build();
      } else {
        requestService.save(request);
        return ResponseEntity.created(new URI("/request" ))
          .body(request);
      }
    }

    // Редактировать заявку
    @PutMapping("/request")
    public ResponseEntity updateRequest(@RequestBody Request request) {

      log.debug("REST request to update request with id : {} ", request.getId());

      if (request.getId() == null) {
        return ResponseEntity.badRequest().build();
      }
      else {
        requestService.save(request);
        return ResponseEntity.ok().body(request);
      }
    }

    // Удалить заявку
    @DeleteMapping("/request/{id}")
    public ResponseEntity deleteRequest(@PathVariable Long id) {
      log.debug("REST request to delete request with id : {}", id);
      requestService.delete(id);
      return ResponseEntity.noContent().build();
    }

    // Получить заявку по id
    @GetMapping("/request/{id}")
    public ResponseEntity getRequestById(@PathVariable Long id) {
      log.debug("REST request to get request with id : {}", id);
      Request res = requestService.get(id);
      if (res != null) {
        return ResponseEntity.ok()
          .body(res);
      } else {
        return ResponseEntity.notFound().build();
      }
    }
}
