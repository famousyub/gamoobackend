package tn.rns.gmao.validator;
import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.EquipmentDto;

import java.util.ArrayList;
import java.util.List;

public class EquipmentValidator {

    public static List<String> validate(EquipmentDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le numéro du serie d'équipement");
            errors.add("Veuillez renseigner le nom d'équipement");
            errors.add("Veuillez renseigner la date achat d'équipement");
            errors.add("Veuillez renseigner le statut d'équipement");
            errors.add("Veuillez renseigner le prix d'équipement");
            errors.add("Veuillez renseigner la mobilité d'équipement ");
            errors.add("Veuillez renseigner la type d'équipement ");
            errors.add("Veuillez renseigner la fonction d'équipement ");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNumserieEq())) {
            errors.add("Veuillez renseigner  le numéro du serie d'équipement");
        }
        if (!StringUtils.hasLength(dto.getNomEq())) {
            errors.add("Veuillez renseigner  le nom d'équipement");
        }
        if (dto.getDateachatEq() == null) {
            errors.add("Veuillez renseigner la date achat d'équipement");
        }
        if (!StringUtils.hasLength(dto.getNomEq())) {
            errors.add("Veuillez renseigner  le statut d'équipement");
        }
        if (dto.getPrix() == null) {
            errors.add("Veuillez renseigner la prix d'équipement");
        }
        if (dto.getMobility() == null) {
            errors.add("Veuillez renseigner la mobilité d'équipement");
        }
        if (!StringUtils.hasLength(dto.getFonctionEq())) {
            errors.add("Veuillez renseigner  la fonction d'équipement");
        }
        return errors;
    }
}