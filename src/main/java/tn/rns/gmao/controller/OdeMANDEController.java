package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.model.OdemandeTraveaux;
import tn.rns.gmao.repository.OGestionaireRepository;
import tn.rns.gmao.repository.OdemandeTraveauRepo;

import javax.validation.Valid;

public class OdeMANDEController {

    @Autowired
    private OdemandeTraveauRepo odemandeTraveauRepo ;

    @Autowired
    private OGestionaireRepository oGestionaireRepository;

    @GetMapping("/posts/{postId}/comments")
    public Page<OdemandeTraveaux> getAllCommentsByPostId(@PathVariable (value = "postId") Long postId,
                                                         Pageable pageable) {
        return odemandeTraveauRepo.findByOGestionnaireId(postId, pageable);
    }

    @PostMapping("/posts/{postId}/comments")
    public OdemandeTraveaux createComment(@PathVariable (value = "postId") Long postId,
                                 @Valid @RequestBody OdemandeTraveaux comment) {
        return odemandeTraveauRepo.findById(postId).map(post -> {
            comment.setOGestionnaire(post.getOGestionnaire());
            return odemandeTraveauRepo.save(comment);
        }).orElseThrow(() -> new InvalidEntityException("PostId " + postId + " not found"));
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public OdemandeTraveaux updateComment(@PathVariable (value = "postId") Long postId,
                                 @PathVariable (value = "commentId") Long commentId,
                                 @Valid @RequestBody OdemandeTraveaux commentRequest) {
        if(!oGestionaireRepository.existsById(postId)) {
            throw new InvalidEntityException("PostId " + postId + " not found");
        }

        return odemandeTraveauRepo.findById(commentId).map(comment -> {
            comment.setAffectation(commentRequest.getAffectation());
            comment.setStatutDT(commentRequest.getStatutDT());
            return odemandeTraveauRepo.save(comment);
        }).orElseThrow(() -> new InvalidEntityException("CommentId " + commentId + "not found"));
    }

    @DeleteMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable (value = "postId") Long postId,
                                           @PathVariable (value = "commentId") Long commentId) {
        return odemandeTraveauRepo.findByIdAndOGestionnaireId(commentId, postId).map(comment -> {
            odemandeTraveauRepo.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new InvalidEntityException("Comment not found with id " + commentId + " and postId " + postId));
    }
}
