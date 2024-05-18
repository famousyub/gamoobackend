package tn.rns.gmao.services;

import tn.rns.gmao.dto.EquipmentDto;
import tn.rns.gmao.model.Equipment;


import java.util.List;

public interface EquipmentService {

    EquipmentDto add(EquipmentDto dto);


    EquipmentDto findById(Integer idEq);

    List<EquipmentDto> findAll();

    void update(Integer idEq, EquipmentDto dto);

    void delete(Integer idEq);
}
