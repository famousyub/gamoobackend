package tn.rns.gmao.services;

import tn.rns.gmao.dto.UtilisateurDto;


import java.util.List;

public interface UtilisateurService {

    UtilisateurDto add(UtilisateurDto dto);

    UtilisateurDto findById(Integer id);

    List<UtilisateurDto> findAll();

    void update(Integer id, UtilisateurDto dto);

    void delete(Integer id);




}
