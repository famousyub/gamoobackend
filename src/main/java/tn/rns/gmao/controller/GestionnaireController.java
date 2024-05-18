package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.GestionnaireApi;
import tn.rns.gmao.dto.GestionnaireDto;
import tn.rns.gmao.services.GestionnaireService;
import tn.rns.gmao.services.SurveillantService;

import java.util.List;

@RestController
public class GestionnaireController implements GestionnaireApi {

    private GestionnaireService gestionnaireService;

    @Autowired
    public GestionnaireController(
            GestionnaireService gestionnaireService){
        this.gestionnaireService = gestionnaireService;
    }

    @Override
    public GestionnaireDto add(GestionnaireDto dto) {
        return gestionnaireService.add(dto);
    }

    @Override
    public GestionnaireDto findById(Integer id) {
        return gestionnaireService.findById(id);
    }

    @Override
    public List<GestionnaireDto> findAll() {
        return gestionnaireService.findAll();
    }

    @Override
    public void update(Integer id, GestionnaireDto dto) {
        gestionnaireService.update(id,dto);

    }

    @Override
    public void delete(Integer idGest) {
        gestionnaireService.delete(idGest);

    }
}
