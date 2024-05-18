package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.InterventionDto;

import java.util.ArrayList;
import java.util.List;

public class InterventionValidator {

    public static List<String> validate(InterventionDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le statut d'intervention ");
            errors.add("Veuillez renseigner la date d'intervention ");
            errors.add("Veuillez renseigner la description d'intervention ");
        }
        if (!StringUtils.hasLength(dto.getStatutInter())) {
            errors.add("Veuillez renseigner le statut d'intervention");
        }

        if (dto.getDateInter() == null) {
            errors.add("Veuillez renseigner la date d'intervention");
        }
        if (!StringUtils.hasLength(dto.getDescriptionIner())) {
            errors.add("Veuillez renseigner la description d'intervention");
        }
        return errors;
    }
    }