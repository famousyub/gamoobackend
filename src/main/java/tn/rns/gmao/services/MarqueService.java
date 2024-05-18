package tn.rns.gmao.services;

import tn.rns.gmao.dto.MarqueDto;
import tn.rns.gmao.dto.RequestWorkDto;

import java.util.List;

public interface MarqueService {

    MarqueDto add(MarqueDto dto);


    MarqueDto findById(Integer idMarque);

    List<MarqueDto> findAll();

    void update(Integer idMarque,MarqueDto dto);

    void delete(Integer idMarque);
}
