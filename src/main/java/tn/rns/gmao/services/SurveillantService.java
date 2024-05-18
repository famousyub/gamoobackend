package tn.rns.gmao.services;

import tn.rns.gmao.dto.SurveillantDto;

import java.util.List;

public interface SurveillantService {


    SurveillantDto add(SurveillantDto dto);

    SurveillantDto findById(Integer id);

    List<SurveillantDto> findAll();

    void update(Integer id, SurveillantDto dto);

    void delete(Integer id);
}
