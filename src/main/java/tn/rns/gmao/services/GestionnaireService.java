package tn.rns.gmao.services;

import tn.rns.gmao.dto.GestionnaireDto;

import java.util.List;

public interface GestionnaireService {

    GestionnaireDto add(GestionnaireDto dto);

    GestionnaireDto findById(Integer id);

    List<GestionnaireDto> findAll();

    void update(Integer id,GestionnaireDto dto);

    void delete(Integer id);
}
