package tn.rns.gmao.services;

import tn.rns.gmao.dto.InterventionDto;

import java.util.List;

public interface InterventionService {

    InterventionDto add (InterventionDto dto);

    InterventionDto findById(Integer idInter);

    List<InterventionDto> findAll();

    void update(Integer idInter,InterventionDto dto);

    void delete(Integer idInter);
}
