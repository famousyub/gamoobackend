package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.FournisseurApi;
import tn.rns.gmao.dto.FournisseurDto;
import tn.rns.gmao.model.Fournisseur;
import tn.rns.gmao.services.FournisseurService;
import tn.rns.gmao.services.MarqueService;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService;

    @Autowired
    public FournisseurController(
            FournisseurService fournisseurService){
        this.fournisseurService = fournisseurService;
    }


    @Override
    public FournisseurDto add(FournisseurDto dto) {
        return fournisseurService.add(dto);
    }

    @Override
    public FournisseurDto findById(Integer idF) {
        return fournisseurService.findById(idF);
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void update(Integer idF, FournisseurDto dto) {
         fournisseurService.update(idF,dto);
    }

    @Override
    public void delete(Integer idF) {
          fournisseurService.delete(idF);
    }
}
