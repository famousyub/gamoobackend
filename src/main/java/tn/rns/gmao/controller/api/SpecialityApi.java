package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.SpecialityDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("specialities")
public interface SpecialityApi {

    @PostMapping(value = APP_ROOT + "/specialities/add")
    @ApiOperation(value = "Ajouter une spécialité", notes = "Cette méthode permet d'ajouter une nouvelle spécialité" )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La spécialité a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet speciality n'est pas valide")
    })
    SpecialityDto add(@RequestBody SpecialityDto dto);



    @GetMapping(value = APP_ROOT + "/specialities/{idSpec}")
    @ApiOperation(value = "Rechercher une specialite par ID", notes = "Cette methode permet de chercher une specialite par son ID", response = SpecialityDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La specialite a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune specialite n'existe dans la BDD avec l'ID fourni")
    })
    SpecialityDto findById(@PathVariable("idSpec")Integer idSpec);


    @GetMapping(value = APP_ROOT + "/specialities/all")
    @ApiOperation(value = "Renvoi la liste des specialities", notes = "Cette methode permet de chercher et renvoyer la liste des specialities qui existent "
            + "dans la BDD", responseContainer = "List<SpecialityDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des specialities / Une specialite vide")
    })
    List<SpecialityDto> findAll();



    @PutMapping(value = APP_ROOT + "/specialities/update/{idSpec}")
    @ApiOperation(value = "Mettre a jour une specialite ", notes = "Cette methode permet de mettre a jour une specialite par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La specialite a ete mise a jour avec succes")
    })
    void update(@PathVariable("idSpec")Integer idSpec, SpecialityDto dto);


    @DeleteMapping(value = APP_ROOT + "/specialities/delete/{idSpec}")
    @ApiOperation(value = "Supprimer une specialite ", notes = "Cette methode permet de supprimer une specialite par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La specialite a ete supprime avec succes")
    })
    void delete(@PathVariable("idSpec")Integer idSpec);
}
