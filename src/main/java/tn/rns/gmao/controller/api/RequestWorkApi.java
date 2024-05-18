package tn.rns.gmao.controller.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.RequestWorkDto;


import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("requests")
public interface RequestWorkApi {


    @PostMapping(value = APP_ROOT + "/requests/add")
    @ApiOperation(value = "Ajouter une demande de travaux", notes = "Cette méthode permet d'ajouter une nouvelle demande de travaux")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "La demande de travaux a été ajoutée avec succès"),
            @ApiResponse(code = 400, message = "L'objet demande de travaux n'est pas valide")
    })
    RequestWorkDto add(@RequestBody RequestWorkDto dto);



    @GetMapping(value = APP_ROOT + "/requests/{idDT}")
    @ApiOperation(value = "Rechercher une demande de travaux  par ID", notes = "Cette methode permet de chercher une demande de travaux  par son ID", response = RequestWorkDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La demande de travaux  a ete trouve dans la BDD"),
            @ApiResponse(code = 404, message = "Aucune demande de travaux  n'existe dans la BDD avec l'ID fourni")
    })
    RequestWorkDto findById(@PathVariable("idDT")Integer idDT);


    @GetMapping(value = APP_ROOT + "/requests/all")
    @ApiOperation(value = "Renvoi la liste des demandes", notes = "Cette methode permet de chercher et renvoyer la liste des demandes qui existent "
            + "dans la BDD", responseContainer = "List<RequestWorkDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La liste des demandes de travaux / Une demande vide")
    })
    List<RequestWorkDto> findAll();


    @PutMapping(value = APP_ROOT + "/requests/update/{idDT}")
    @ApiOperation(value = "Mettre a jour une demande de travaux ", notes = "Cette methode permet de mettre a jour une demande de travaux par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La demande de travaux a ete mise a jour avec succes")
    })
    void update(@PathVariable("idDT")Integer idDT,RequestWorkDto dto);


    @DeleteMapping(value = APP_ROOT + "/requests/delete/{idDT}")
    @ApiOperation(value = "Supprimer une demande de travaux", notes = "Cette methode permet de supprimer une demande de travaux par ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La demande de travaux a ete supprime avec succes")
    })
    void delete(@PathVariable("idDT")Integer idDT);
}
