package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.GestionnaireDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("gestionnaires")
public interface GestionnaireApi {

    @PostMapping(value = APP_ROOT + "/gestionnaires/add")
    GestionnaireDto add(@RequestBody GestionnaireDto dto);


    @GetMapping(value = APP_ROOT + "/gestionnaires/{idGest}")
    GestionnaireDto findById(@PathVariable("idGest") Integer id);


    @GetMapping(value = APP_ROOT + "/gestionnaires/all")
    List<GestionnaireDto> findAll();


    @PutMapping(value = APP_ROOT + "/gestionnaires/update/{idGest}")
    void update(@PathVariable("idGest") Integer id,GestionnaireDto dto);


    @DeleteMapping(value = APP_ROOT + "/gestionnaires/delete/{idGest}")
    void delete(@PathVariable("idGest") Integer id);
}
