package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.UtilisateurDto;
import tn.rns.gmao.model.Utilisateur;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;
import static tn.rns.gmao.utils.Constants.UTILISATEUR_ENDPOINT;

@Api("utilisateurs")
public interface UtilisateurApi {

    @PostMapping(value = UTILISATEUR_ENDPOINT + "/utilisateurs/add")
    UtilisateurDto add(@RequestBody UtilisateurDto dto);



    @GetMapping(UTILISATEUR_ENDPOINT + "/{idU}")
    UtilisateurDto findById(@PathVariable("idU")Integer id);


    @GetMapping(UTILISATEUR_ENDPOINT + "/all")
    List<UtilisateurDto> findAll();

    @PutMapping(value = UTILISATEUR_ENDPOINT+ "/update/{idU}")
    void update(@PathVariable("idU")Integer id, UtilisateurDto dto);



    @DeleteMapping(UTILISATEUR_ENDPOINT + "/delete/{idU}")
    void delete(@PathVariable("idU")Integer id);
}
