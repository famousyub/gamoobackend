package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.model.OGestionnaire;
import tn.rns.gmao.repository.OGestionaireRepository;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/gestionnaire")
public class OGestionnaireController {

    @Autowired
    private OGestionaireRepository oGestionaireRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;




    @GetMapping("/ogestion")
    public Page<OGestionnaire> getAllPosts(Pageable pageable) {
        return oGestionaireRepository.findAll(pageable);
    }

    @PostMapping("/ogestion")
    public OGestionnaire createPost(@Valid @RequestBody OGestionnaire post) {

        post.setPassword(bCryptPasswordEncoder.encode(post.getPassword()));
        return oGestionaireRepository.save(post);
    }

    @PutMapping("/ogestion/{postId}")
    public OGestionnaire updatePost(@PathVariable("postId") Long postId, @Valid @RequestBody OGestionnaire postRequest) {
        return oGestionaireRepository.findById(postId).map(post -> {
            post.setEmail(postRequest.getEmail());
            post.setUsername(postRequest.getUsername());
            post.setRole(postRequest.getRole());
            post.setPassword(bCryptPasswordEncoder.encode(postRequest.getPassword()));
            return oGestionaireRepository.save(post);
        }).orElseThrow(() -> new InvalidEntityException("PostId " + postId + " not found"));
    }

    @GetMapping("/ogestion/{id}")
    public  ResponseEntity<?>  getpgestionbyId(@PathVariable("id") Long id)
    {

         OGestionnaire op = oGestionaireRepository.findById(id).get();

         return  ResponseEntity.ok().body(op);
    }


    @DeleteMapping("/ogestion/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        return oGestionaireRepository.findById(postId).map(post -> {
            oGestionaireRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new InvalidEntityException("PostId " + postId + " not found"));
    }


}
