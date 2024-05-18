package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.SpecialityApi;
import tn.rns.gmao.dto.SpecialityDto;
import tn.rns.gmao.services.SpecialityService;

import java.util.List;

@RestController
@CrossOrigin("*")
public class SpecialityController implements SpecialityApi {

    private SpecialityService specialityService;

    @Autowired
    public SpecialityController(
            SpecialityService specialityService){
        this.specialityService = specialityService;
    }


    @Override
    public SpecialityDto add(SpecialityDto dto) {
        return specialityService.add(dto);

    }

    @Override
    public SpecialityDto findById(Integer idSpec) {
        return specialityService.findById(idSpec);
    }

    @Override
    public List<SpecialityDto> findAll() {
        return specialityService.findAll();
    }

    @Override
    public void update(Integer idSpec, SpecialityDto dto) {
        specialityService.update(idSpec,dto);
    }

    @Override
    public void delete(Integer idSpec) {
        specialityService.delete(idSpec);
    }
}
