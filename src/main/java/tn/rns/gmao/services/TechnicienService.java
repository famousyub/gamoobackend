package tn.rns.gmao.services;


import tn.rns.gmao.dto.TechnicienDto;
import tn.rns.gmao.dto.UtilisateurDto;

import java.util.List;

public interface TechnicienService {

    TechnicienDto add(TechnicienDto dto);

    TechnicienDto findById(Integer id);

    List<TechnicienDto> findAll();

    void update(Integer id, TechnicienDto dto);

    void delete(Integer id);
}
