package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.TechnicienDto;

import java.util.ArrayList;
import java.util.List;

public class TechnicienValidator {

    public static List<String> validate(TechnicienDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner la specialité du technicien");
            errors.add("Veuillez renseigner le numéro du telephone du technicien");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getSpetialiteTech())) {
            errors.add("Veuillez renseigner la specialité du technicien");
        }
        if (!StringUtils.hasLength(dto.getTelTech())) {
            errors.add("Veuillez renseigner le numéro du telephone du technicien");
        }
        return errors;
    }
}
