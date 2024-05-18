package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.EquipmentDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Equipment;
import tn.rns.gmao.repository.EquipmentRepository;
import tn.rns.gmao.services.EquipmentService;
import tn.rns.gmao.validator.EquipmentValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository equipmentRepository;
    @Autowired
    public EquipmentServiceImpl(
            EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public EquipmentDto add(EquipmentDto dto) {
        List<String> errors = EquipmentValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'equipement n'est pas valide {}", dto);
            throw new InvalidEntityException("L'equipement n'est pas valide", ErrorCodes.EQUIPMENT_NOT_VALID, errors);
        }

        Equipment equipmentToAdd = EquipmentDto.toEntity(dto);
        equipmentToAdd.setIdEq(dto.getIdEq());
        equipmentRepository.save(equipmentToAdd);

        return dto;
    }


    @Override
    public EquipmentDto findById(Integer idEq) {
        if (idEq == null) {
            log.error("L'ID d'equipement' est null");
            return null;
        }

        return equipmentRepository.findById(idEq).map(EquipmentDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune equipement avec l'ID = " + idEq + " n' ete trouve dans la BDD",
                        ErrorCodes.EQUIPMENT_NOT_FOUND)
        );
    }

    @Override
    public List<EquipmentDto> findAll() {
        return equipmentRepository.findAll().stream()
                .map(EquipmentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idEq, EquipmentDto dto) {
        checkIdEq(idEq);
        if (idEq == null) {
            log.error("L'ID d'equipement est null");
            throw new InvalidOperationException("Impossible de modifier l'equipemenent avec un ID null",
                    ErrorCodes.EQUIPMENT_NON_MODIFIABLE);
        }
        Optional<Equipment> equipmentOptional = equipmentRepository.findById(idEq);
        if (equipmentOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucun equipement n'a ete trouve avec l'ID " + idEq, ErrorCodes.FAMILY_NOT_FOUND);
        }
        Equipment equipmentToSaved = equipmentOptional.get();
        equipmentToSaved.setIdEq(dto.getIdEq());
        equipmentRepository.save(equipmentToSaved);
    }

    private void checkIdEq(Integer idEq) {
        if (idEq == null) {
            log.error(" ID equipement est null");
            throw new InvalidOperationException("Impossible de modifier l'equipement' avec un ID null",
                    ErrorCodes.EQUIPMENT_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idEq) {
        if (idEq == null) {
            log.error("L'ID d'equipement' est null");
            return;
        }
       equipmentRepository.deleteById(idEq);
    }

}
