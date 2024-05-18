package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CurrentUserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/curent/user/{username}")

    public ResponseEntity<?> currntR(@PathVariable ("username") String username)
    {


        UserEntity userEntity = userRepository.findByUsername(username).get();


        return  ResponseEntity.ok().body(userEntity);
    }
}
