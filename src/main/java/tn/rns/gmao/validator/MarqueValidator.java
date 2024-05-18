package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.MarqueDto;

import java.util.ArrayList;
import java.util.List;

public class MarqueValidator {
    public static List<String> validate(MarqueDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du marque ");
        }
        if (!StringUtils.hasLength(dto.getNomMarque())) {
            errors.add("Veuillez renseigner le nom du marque");
        }
        return errors;
    }
}
