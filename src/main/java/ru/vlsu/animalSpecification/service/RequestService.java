package ru.vlsu.animalSpecification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vlsu.animalSpecification.domain.Request;
import ru.vlsu.animalSpecification.domain.User;
import ru.vlsu.animalSpecification.domain.emun.RequestStatus;
import ru.vlsu.animalSpecification.repository.RequestRepository;

import java.util.List;

@Service
@Transactional
public class RequestService {

    private static final Logger log = LoggerFactory.getLogger(RequestService.class);


    private final RequestRepository repo;

    private final UserService userService;

    @Autowired
    public RequestService(RequestRepository repo, UserService userService) {
      this.repo = repo;
      this.userService = userService;
    }

    public Request save(Request req, String userName) {
        log.debug("Request save request : {} by user with userName : {}", req, userName);
        User master = userService.findByUsername(userName);
        if (req.getId() == null) {
          req.setRecipient(master);
          req.setStatus(RequestStatus.CREATED);
        }

        return repo.save(req);
    }

    public List<Request> listAll() {
        return (List<Request>) repo.findAll();
    }

    public Request get(Long id) {
        log.debug("Find request by id: {}", id);
        Request res = null;
        try {
          res = repo.findById(id).get();
        } catch (Exception e){
          log.debug("Error finding vaccine by id: " + e.getMessage());
        }
        return res;
    }

    public void delete(Long id) {
        log.debug("Delete request with id: {}", id);
        repo.deleteById(id);
    }

    public List<Request> findRequestByUser(String userName) {
      log.debug("Request to get requests by user with userName : {}", userName);
      User recipient = userService.findByUsername(userName);
      if (recipient != null) {
        return repo.findAllByRecipient(recipient);
      } else {
        return null;
      }
    }

}
