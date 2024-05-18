package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.MarqueDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("marques")
public interface MarqueApi {


    @PostMapping(value = APP_ROOT + "/marques/add")
    @ApiOperation(value = "Ajouter une marque", notes = "Cette méthode permet d'ajouter une nouvelle marque")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La marque a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet marque n'est pas valide")
    })
    MarqueDto add(@RequestBody MarqueDto dto);


    @GetMapping(value = APP_ROOT + "/marques/{idMarque}")
    @ApiOperation(value = "Rechercher une marque par ID", notes = "Cette methode permet de chercher une marque par son ID", response = MarqueDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La marque a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune marque n'existe dans la BDD avec l'ID fourni")
    })
    MarqueDto findById(@PathVariable("idMarque")Integer idMarque);


    @GetMapping(value = APP_ROOT + "/marques/all")
    @ApiOperation(value = "Renvoi la liste des marques", notes = "Cette methode permet de chercher et renvoyer la liste des marques qui existent "
            + "dans la BDD", responseContainer = "List<MarqueDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des marques / Une marque vide")
    })
    List<MarqueDto> findAll();


    @PutMapping(value = APP_ROOT + "/marques/update/{idMarque}")
    @ApiOperation(value = "Mettre a jour une marque ", notes = "Cette methode permet de mettre a jour une marque par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La marque a ete mise a jour avec succes")
    })
    void update(@PathVariable("idMarque")Integer idMarque,MarqueDto dto);


    @DeleteMapping(value = APP_ROOT + "/marques/delete/{idMarque}")
    @ApiOperation(value = "Supprimer une marque ", notes = "Cette methode permet de supprimer une marque par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La marque a ete supprime avec succes")
    })
    void delete(@PathVariable("idMarque")Integer idMarque);

}
