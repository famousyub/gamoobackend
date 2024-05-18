package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.FournisseurDto;
import tn.rns.gmao.model.Fournisseur;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("fournisseur")
public interface FournisseurApi {

    @PostMapping(value = APP_ROOT + "/fournisseur/add")
    @ApiOperation(value = "Ajouter un fournisseur", notes = "Cette méthode permet d'ajouter un nouveau fournisseur")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Le fournisseur a été ajouté avec succès"),
            @ApiResponse(code = 400, message = "L'objet fournisseur n'est pas valide")
    })
    FournisseurDto add(@RequestBody FournisseurDto dto);



    @GetMapping(value = APP_ROOT + "/fournisseur/{idF}")
    @ApiOperation(value = "Rechercher un fournisseur par ID", notes = "Cette methode permet de chercher un fournisseur par son ID", response = FournisseurDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune fournisseur n'existe dans la BDD avec l'ID fourni")
    })
    FournisseurDto findById(@PathVariable("idF")Integer idF);


    @GetMapping(value = APP_ROOT + "/fournisseur/all")
    @ApiOperation(value = "Renvoi la liste des fournisseurs", notes = "Cette methode permet de chercher et renvoyer la liste des fournisseurs qui existent "
            + "dans la BDD", responseContainer = "List<fournisseurDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des fournisseurs / Un fournisseur vide")
    })
    List<FournisseurDto> findAll();


    @PutMapping(value = APP_ROOT + "/fournisseur/update/{idF}")
    @ApiOperation(value = "Mettre a jour un fournisseur ", notes = "Cette methode permet de mettre a jour un fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a ete mise a jour avec succes")
    })
    void update(@PathVariable("idF")Integer idF, FournisseurDto dto);


    @DeleteMapping(value = APP_ROOT + "/fournisseur/delete/{idF}")
    @ApiOperation(value = "Supprimer un fournisseur", notes = "Cette methode permet de supprimer un fournisseur par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Le fournisseur a ete supprime avec succes")
    })
    void delete(@PathVariable("idF")Integer idF);
}
