package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.MarqueApi;
import tn.rns.gmao.dto.MarqueDto;
import tn.rns.gmao.services.MarqueService;

import java.util.List;

@RestController
public class MarqueController implements MarqueApi {

    private MarqueService marqueService;

    @Autowired
    public MarqueController(
            MarqueService marqueService){
        this.marqueService = marqueService;
    }

    @Override
    public MarqueDto add(MarqueDto dto) {
        return marqueService.add(dto);
    }

    @Override
    public MarqueDto findById(Integer idMarque) {
        return marqueService.findById(idMarque);
    }

    @Override
    public List<MarqueDto> findAll() {
        return marqueService.findAll();
    }

    @Override
    public void update(Integer idMarque, MarqueDto dto) {
        marqueService.update(idMarque, dto);
    }

    @Override
    public void delete(Integer idMarque) {
        marqueService.delete(idMarque);
    }
}
