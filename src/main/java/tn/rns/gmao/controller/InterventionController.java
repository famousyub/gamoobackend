package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.InterventionApi;
import tn.rns.gmao.dto.InterventionDto;
import tn.rns.gmao.model.Intervention;
import tn.rns.gmao.services.FamilyService;
import tn.rns.gmao.services.InterventionService;

import java.util.List;

@RestController
public class InterventionController implements InterventionApi {


    private InterventionService interventionService;

    @Autowired
    public InterventionController(
            InterventionService interventionService){
        this.interventionService = interventionService;
    }

    @Override
    public InterventionDto add(InterventionDto dto) {
        return interventionService.add(dto);
    }


    @Override
    public InterventionDto findById(Integer idInter) {
        return interventionService.findById(idInter);
    }

    @Override
    public List<InterventionDto> findAll() {
        return interventionService.findAll();
    }

    @Override
    public void update(Integer idInter, InterventionDto dto) {
        interventionService.update(idInter,dto);
    }

    @Override
    public void delete(Integer idInter) {
        interventionService.delete(idInter);
    }
}
