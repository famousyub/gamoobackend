package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.FamilyApi;
import tn.rns.gmao.dto.FamilyDto;
import tn.rns.gmao.services.FamilyService;

import java.util.List;

@RestController
public class FamilyController implements FamilyApi {

    private FamilyService familyService;

    @Autowired
    public FamilyController(
            FamilyService familyService){
        this.familyService = familyService;
    }

    @Override
    public FamilyDto add(FamilyDto dto) {
        return familyService.add(dto);
    }

    @Override
    public FamilyDto findById(Integer idFam) {
        return familyService.findById(idFam);
    }

    @Override
    public List<FamilyDto> findAll() {
        return familyService.findAll();
    }

    @Override
    public void update(Integer idFam, FamilyDto dto) {
        familyService.update(idFam,dto);
    }

    @Override
    public void delete(Integer idFam) {
        familyService.delete(idFam);
    }
}
