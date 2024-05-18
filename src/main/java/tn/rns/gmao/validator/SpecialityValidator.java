package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.SpecialityDto;

import java.util.ArrayList;
import java.util.List;

public class SpecialityValidator {

    public static List<String> validate(SpecialityDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du speciality");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNomSpec())) {
            errors.add("Veuillez renseigner le nom du speciality");
        }
        return errors;
    }
}
