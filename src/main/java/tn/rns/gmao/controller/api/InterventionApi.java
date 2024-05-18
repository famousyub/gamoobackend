package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.InterventionDto;
import tn.rns.gmao.dto.MarqueDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("interventions")
public interface InterventionApi {


    @PostMapping(value = APP_ROOT + "/interventions/add")
    @ApiOperation(value = "Ajouter une intervention ", notes = "Cette méthode permet d'ajouter une nouvelle famille ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'intervention  a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet intervention  n'est pas valide")
    })
    InterventionDto add(@RequestBody InterventionDto dto);



    @GetMapping(value = APP_ROOT + "/interventions/{idInter}")
    @ApiOperation(value = "Rechercher une intervention par ID", notes = "Cette methode permet de chercher une intervention par son ID", response = InterventionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La intervention a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune intervention n'existe dans la BDD avec l'ID fourni")
    })
    InterventionDto findById(@PathVariable("idInter")Integer idInter);


    @GetMapping(value = APP_ROOT + "/interventions/all")
    @ApiOperation(value = "Renvoi la liste des interventions", notes = "Cette methode permet de chercher et renvoyer la liste des interventions qui existent "
            + "dans la BDD", responseContainer = "List<InterventionDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des interventions / Une intervention vide")
    })
    List<InterventionDto> findAll();


    @PutMapping(value = APP_ROOT + "/interventions/update/{idInter}")
    @ApiOperation(value = "Mettre a jour une intervention ", notes = "Cette methode permet de mettre a jour une intervention par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La intervention a ete mise a jour avec succes")
    })
    void update(@PathVariable("idInter")Integer idInter,InterventionDto dto);


    @DeleteMapping(value = APP_ROOT + "/interventions/delete/{idInter}")
    @ApiOperation(value = "Supprimer une intervention ", notes = "Cette methode permet de supprimer une intervention par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La intervention a ete supprime avec succes")
    })
    void delete(@PathVariable("idInter")Integer idInter);
}
