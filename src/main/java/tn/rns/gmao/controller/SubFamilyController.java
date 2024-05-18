package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.SubFamilyApi;
import tn.rns.gmao.dto.SubFamilyDto;
import tn.rns.gmao.services.SubFamilyService;

import java.util.List;

@RestController
public class SubFamilyController implements SubFamilyApi {

    private SubFamilyService subFamilyService;

    @Autowired
    public SubFamilyController(
           SubFamilyService subFamilyService){
        this.subFamilyService = subFamilyService;
    }


    @Override
    public SubFamilyDto add(SubFamilyDto dto) {
        return subFamilyService.add(dto);
    }


    @Override
    public SubFamilyDto findById(Integer idSubFam) {
        return subFamilyService.findById(idSubFam);
    }

    @Override
    public List<SubFamilyDto> findAll() {
        return subFamilyService.findAll();
    }

    @Override
    public void update(Integer idSubFam, SubFamilyDto dto) {
        subFamilyService.update(idSubFam,dto);
    }

    @Override
    public void delete(Integer idSubFam) {
        subFamilyService.delete(idSubFam);
    }
}
