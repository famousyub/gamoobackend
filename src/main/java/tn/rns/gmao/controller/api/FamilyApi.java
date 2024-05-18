package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.FamilyDto;
import tn.rns.gmao.dto.MarqueDto;
import tn.rns.gmao.dto.SubFamilyDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("families")
public interface FamilyApi {


    @PostMapping(value = APP_ROOT + "/families/add")
    @ApiOperation(value = "Ajouter une famille ", notes = "Cette méthode permet d'ajouter une nouvelle famille ")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La famille  a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet famille  n'est pas valide")
    })
    FamilyDto add(@RequestBody FamilyDto dto);


    @GetMapping(value = APP_ROOT + "/families/{idFam}")
    @ApiOperation(value = "Rechercher une famille par ID", notes = "Cette methode permet de chercher une famille par son ID", response = FamilyDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La famille a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune famille n'existe dans la BDD avec l'ID fourni")
    })
    FamilyDto findById(@PathVariable("idFam")Integer idFam);


    @GetMapping(value = APP_ROOT + "/families/all")
    @ApiOperation(value = "Renvoi la liste des familles", notes = "Cette methode permet de chercher et renvoyer la liste des familles qui existent "
            + "dans la BDD", responseContainer = "List<FamilYDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des familles / Une famille vide")
    })
    List<FamilyDto> findAll();


    @PutMapping(value = APP_ROOT + "/families/update/{idFam}")
    @ApiOperation(value = "Mettre a jour une famille ", notes = "Cette methode permet de mettre a jour une famille par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La famille a ete mise a jour avec succes")
    })
    void update(@PathVariable("idFam")Integer idFam,FamilyDto dto);


    @DeleteMapping(value = APP_ROOT + "/families/delete/{idFam}")
    @ApiOperation(value = "Supprimer une famille ", notes = "Cette methode permet de supprimer une famille par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La famille a ete supprime avec succes")
    })
    void delete(@PathVariable("idFam")Integer idFam);
}
