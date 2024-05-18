package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.TechnicienDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("techniciens")
public interface TechnicienApi {

    @PostMapping(value = APP_ROOT + "/techniciens/add")
    TechnicienDto add(@RequestBody TechnicienDto dto);


    @GetMapping(value = APP_ROOT + "/techniciens/{idTech}")
    TechnicienDto findById(@PathVariable("idTech") Integer id);


    @GetMapping(value = APP_ROOT + "/techniciens/all")
    List<TechnicienDto> findAll();


    @PutMapping(value = APP_ROOT + "/techniciens/update/{idTech}")
    void update(@PathVariable("idTech")Integer id, TechnicienDto dto);


    @DeleteMapping(value = APP_ROOT + "/techniciens/delete/{idTech}")
    void delete(@PathVariable("idTech")Integer id);

}
