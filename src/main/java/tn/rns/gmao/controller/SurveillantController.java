package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.SurveillantApi;
import tn.rns.gmao.dto.SurveillantDto;
import tn.rns.gmao.services.SurveillantService;

import java.util.List;

@RestController
public class SurveillantController implements SurveillantApi {

    private SurveillantService surveillantService;

    @Autowired
    public SurveillantController(
            SurveillantService surveillantService){
        this.surveillantService = surveillantService;
    }

    @Override
    public SurveillantDto add(SurveillantDto dto) {
        return surveillantService.add(dto);
    }

    @Override
    public SurveillantDto findById(Integer id) {
        return surveillantService.findById(id);
    }

    @Override
    public List<SurveillantDto> findAll() {
        return surveillantService.findAll();
    }

    @Override
    public void update(Integer id, SurveillantDto dto) {
         surveillantService.update(id,dto);
    }

    @Override
    public void delete(Integer id) {
        surveillantService.delete(id);

    }
}
