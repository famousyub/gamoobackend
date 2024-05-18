package tn.rns.gmao.services;

import tn.rns.gmao.dto.RequestWorkDto;
import tn.rns.gmao.dto.SpecialityDto;

import java.util.List;

public interface RequestWorkService {

    RequestWorkDto add(RequestWorkDto dto);


    RequestWorkDto findById(Integer idDT);

    List<RequestWorkDto> findAll();

    void update(Integer idDT,RequestWorkDto dto);

    void delete(Integer idDT);
}
