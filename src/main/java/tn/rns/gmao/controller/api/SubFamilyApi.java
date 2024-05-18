package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.SubFamilyDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("subfamilies")
public interface SubFamilyApi {


    @PostMapping(value = APP_ROOT + "/subfamilies/add")
    @ApiOperation(value = "Ajouter une sous-famille ", notes = "Cette méthode permet d'ajouter une nouvelle sous-famille ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La sous-famille  a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet sous-famille  n'est pas valide")
    })
    SubFamilyDto add(@RequestBody SubFamilyDto dto);


    @GetMapping(value = APP_ROOT + "/subfamilies/{idSubFam}")
    @ApiOperation(value = "Rechercher une sous-famille par ID", notes = "Cette methode permet de chercher une sous-famille par son ID", response = SubFamilyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La sous-famille a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune sous-famille n'existe dans la BDD avec l'ID fourni")
    })
    SubFamilyDto findById(@PathVariable("idSubFam")Integer idSubFam);


    @GetMapping(value = APP_ROOT + "/subfamilies/all")
    @ApiOperation(value = "Renvoi la liste des sous-familles", notes = "Cette methode permet de chercher et renvoyer la liste des sous-familles qui existent "
            + "dans la BDD", responseContainer = "List<SubFamilyDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des sous-familles / Une sous-famille vide")
    })
    List<SubFamilyDto> findAll();


    @PutMapping(value = APP_ROOT + "/subfamilies/update/{idSubFam}")
    @ApiOperation(value = "Mettre a jour une sous-famille ", notes = "Cette methode permet de mettre a jour une sous-famille par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La sous-famille a ete mise a jour avec succes")
    })
    void update(@PathVariable("idSubFam")Integer idSubFam,SubFamilyDto dto);


    @DeleteMapping(value = APP_ROOT + "/subfamilies/delete/{idSubFam}")
    @ApiOperation(value = "Supprimer une sous-famille ", notes = "Cette methode permet de supprimer une sous-famille par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La sous-famille a ete supprime avec succes")
    })
    void delete(@PathVariable("idSubFam")Integer idSubFam);
}
