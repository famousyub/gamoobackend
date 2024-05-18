package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.UtilisateurApi;
import tn.rns.gmao.dto.UtilisateurDto;
import tn.rns.gmao.services.UtilisateurService;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {


    private UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @Override
    public UtilisateurDto add(UtilisateurDto dto) {
        return utilisateurService.add(dto);
    }


    @Override
    public UtilisateurDto findById(Integer id) {
        return utilisateurService.findById(id);
    }


    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurService.findAll();
    }


    @Override
    public void update(Integer id, UtilisateurDto dto) {
        utilisateurService.update(id,dto);
    }


    @Override
    public void delete(Integer id) {
        utilisateurService.delete(id);
    }
}
