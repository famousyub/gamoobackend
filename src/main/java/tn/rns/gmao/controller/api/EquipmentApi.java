package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.EquipmentDto;


import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("equipments")
public interface EquipmentApi {



    @PostMapping(value = APP_ROOT + "/equipments/add")
    @ApiOperation(value = "Ajouter un equipement ", notes = "Cette méthode permet d'ajouter une nouvel equipement ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "L'equipement' a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet equipement  n'est pas valide")
    })
    EquipmentDto add(@RequestBody EquipmentDto dto);


    @GetMapping(value = APP_ROOT + "/equipments/{idEq}")
    @ApiOperation(value = "Rechercher un equipment par ID", notes = "Cette methode permet de chercher un equipment par son ID", response = EquipmentDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'equipment' a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune equipment n'existe dans la BDD avec l'ID fourni")
    })
    EquipmentDto findById(@PathVariable("idEq")Integer idEq);


    @GetMapping(value = APP_ROOT + "/equipments/all")
    @ApiOperation(value = "Renvoi la liste des equipments", notes = "Cette methode permet de chercher et renvoyer la liste des equipments qui existent "
            + "dans la BDD", responseContainer = "List<EquipmentDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des equipments / Un equipment vide")
    })
    List<EquipmentDto> findAll();


    @PutMapping(value = APP_ROOT + "/equipments/update/{idEq}")
    @ApiOperation(value = "Mettre a jour un equipment ", notes = "Cette methode permet de mettre a jour un equipement par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'equipment a ete mise a jour avec succes")
    })
    void update(@PathVariable("idEq")Integer idEq, EquipmentDto dto);


    @DeleteMapping(value = APP_ROOT + "/equipments/delete/{idEq}")
    @ApiOperation(value = "Supprimer un equipment", notes = "Cette methode permet de supprimer un equipment par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "L'equipment a ete supprime avec succes")
    })
    void delete(@PathVariable("idEq")Integer idEq);
}
