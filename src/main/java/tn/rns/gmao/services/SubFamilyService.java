package tn.rns.gmao.services;

import tn.rns.gmao.dto.MarqueDto;
import tn.rns.gmao.dto.SubFamilyDto;

import java.util.List;

public interface SubFamilyService {

   SubFamilyDto add(SubFamilyDto dto);


    SubFamilyDto findById(Integer idSubFam);

    List<SubFamilyDto> findAll();

    void update(Integer idSubFam,SubFamilyDto dto);

    void delete(Integer idSubFam);
}
