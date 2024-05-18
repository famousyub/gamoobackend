package tn.rns.gmao.services;


import tn.rns.gmao.dto.SpecialityDto;

import java.util.List;

public interface SpecialityService {

   SpecialityDto add (SpecialityDto dto);


    SpecialityDto findById(Integer idSpec);

    List<SpecialityDto> findAll();

    void update(Integer idSpec, SpecialityDto dto);

    void delete(Integer idSpec);
}
