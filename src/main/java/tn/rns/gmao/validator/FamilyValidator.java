package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.FamilyDto;

import java.util.ArrayList;
import java.util.List;

public class FamilyValidator {

        public static List<String> validate(FamilyDto dto) {
            List<String> errors = new ArrayList<>();

            if (dto == null) {
                errors.add("Veuillez renseigner le nom du famille ");
            }
            if (!StringUtils.hasLength(dto.getNomFam())) {
                errors.add("Veuillez renseigner le nom du famille");
            }
            return errors;
        }
    }


