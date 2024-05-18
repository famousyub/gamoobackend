package tn.rns.gmao.controller.api;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.SurveillantDto;

import java.util.List;

import static tn.rns.gmao.utils.Constants.APP_ROOT;

@Api("serveillants")
public interface SurveillantApi {


    @PostMapping(value = APP_ROOT + "/serveillants/add")
    SurveillantDto add(@RequestBody SurveillantDto dto);


    @GetMapping(value = APP_ROOT + "/surveillants/{idSrv}")
    SurveillantDto findById(@PathVariable("idSrv")Integer id);


    @GetMapping(value = APP_ROOT + "/surveillants/all")
    List<SurveillantDto> findAll();


    @PutMapping(value = APP_ROOT + "/surveillants/update/{idSrv}")
    void update(@PathVariable("idSrv")Integer id, SurveillantDto dto);


    @DeleteMapping(value = APP_ROOT + "/surveillants/delete/{idSrv}")
    void delete(@PathVariable("idSrv")Integer id);
}
