package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.TechnicienApi;
import tn.rns.gmao.dto.TechnicienDto;
import tn.rns.gmao.services.FournisseurService;
import tn.rns.gmao.services.TechnicienService;

import java.util.List;

@RestController
public class TechnicienController implements TechnicienApi {


    private TechnicienService technicienService;

    @Autowired
    public TechnicienController(
            TechnicienService technicienService){
        this.technicienService = technicienService;
    }

    @Override
    public TechnicienDto add(TechnicienDto dto) {
        return technicienService.add(dto);
    }

    @Override
    public TechnicienDto findById(Integer id) {
        return technicienService.findById(id);
    }

    @Override
    public List<TechnicienDto> findAll() {
        return technicienService.findAll();
    }

    @Override
    public void update(Integer id, TechnicienDto dto) {
        technicienService.update(id,dto);
    }

    @Override
    public void delete(Integer id) {
         technicienService.delete(id);
    }
}
