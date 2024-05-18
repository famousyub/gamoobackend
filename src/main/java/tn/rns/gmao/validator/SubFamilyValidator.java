package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.SubFamilyDto;

import java.util.ArrayList;
import java.util.List;

public class SubFamilyValidator {


        public static List<String> validate(SubFamilyDto dto) {
            List<String> errors = new ArrayList<>();

            if (dto == null) {
                errors.add("Veuillez renseigner le nom du sous famille ");
            }
            if (!StringUtils.hasLength(dto.getNomSubFam())) {
                errors.add("Veuillez renseigner le nom du sous famille");
            }
            return errors;
        }
    }

