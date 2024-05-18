package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.RequestWorkDto;

import java.util.ArrayList;
import java.util.List;

public class RequestWorkValidator {

    public static List<String> validate(RequestWorkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le statut du demande de travaux");
            errors.add("Veuillez renseigner la date du demande de travaux ");
            errors.add("Veuillez renseigner la description du demande de travaux ");
            errors.add("Veuillez renseigner l'affection du demande de travaux ");
        }
        if (!StringUtils.hasLength(dto.getStatutDT())) {
            errors.add("Veuillez renseigner le statut du demande de travaux");
        }

        if (dto.getDateDT() == null) {
            errors.add("Veuillez renseigner la date du demande de travaux");
        }
        if (!StringUtils.hasLength(dto.getDescriptionDT())) {
            errors.add("Veuillez renseigner la description du demande de travaux");
        }
        if (!StringUtils.hasLength(dto.getAffectation())) {
            errors.add("Veuillez renseigner  l'affection du demande de travaux");
        }
        return errors;
    }
}

