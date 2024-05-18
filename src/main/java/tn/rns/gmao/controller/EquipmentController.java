package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import tn.rns.gmao.controller.api.EquipmentApi;
import tn.rns.gmao.dto.EquipmentDto;
import tn.rns.gmao.services.EquipmentService;

import java.util.List;

public class EquipmentController implements EquipmentApi {

    private EquipmentService equipmentService;

    @Autowired
    public EquipmentController(
           EquipmentService equipmentService){
        this.equipmentService = equipmentService;
    }

    @Override
    public EquipmentDto add(EquipmentDto dto) {
        return equipmentService.add(dto);
    }

    @Override
    public EquipmentDto findById(Integer idEq) {
        return equipmentService.findById(idEq);
    }

    @Override
    public List<EquipmentDto> findAll() {
        return equipmentService.findAll();
    }

    @Override
    public void update(Integer idEq, EquipmentDto dto) {
        equipmentService.update(idEq,dto);

    }

    @Override
    public void delete(Integer idEq) {
        equipmentService.delete(idEq);

    }
}
