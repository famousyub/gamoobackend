package tn.rns.gmao.services;

import tn.rns.gmao.dto.FamilyDto;
import tn.rns.gmao.dto.FournisseurDto;
import tn.rns.gmao.model.Fournisseur;

import java.util.List;

public interface FournisseurService {

    FournisseurDto add(FournisseurDto dto);


    FournisseurDto findById(Integer idF);

    List<FournisseurDto> findAll();

    void update(Integer idF,FournisseurDto dto);

    void delete(Integer idF);
}
