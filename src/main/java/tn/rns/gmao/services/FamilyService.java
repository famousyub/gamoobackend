package tn.rns.gmao.services;

import tn.rns.gmao.dto.FamilyDto;

import java.util.List;

public interface FamilyService {

    FamilyDto add(FamilyDto dto);


    FamilyDto findById(Integer idFam);

    List<FamilyDto> findAll();

    void update(Integer idFam,FamilyDto dto);

    void delete(Integer idFam);
}
