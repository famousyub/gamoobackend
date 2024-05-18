package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.FournisseurDto;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le nom du fournisseur");
            errors.add("Veuillez renseigner le prenom du fournisseur");
            errors.add("Veuillez renseigner l'adresse du fournisseur");
            errors.add("Veuillez renseigner le numero de telephone du fournisseur");
            errors.add("Veuillez renseigner l'email du fournisseur");
            errors.add("Veuillez renseigner la matricule fiscale du fournisseur");
            return errors;
        }
        if (!StringUtils.hasLength(dto.getNomF())) {
            errors.add("Veuillez renseigner le nom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getPrenomF())) {
            errors.add("Veuillez renseigner le prenom du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getAdresseF())) {
            errors.add("Veuillez renseigner l'adresse' du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getTelF())) {
            errors.add("Veuillez renseigner le numero de telephone du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getEmailF())) {
            errors.add("Veuillez renseigner l'email du fournisseur");
        }
        if (!StringUtils.hasLength(dto.getMatriculeFiscale())) {
            errors.add("Veuillez renseigner la matricule fiscale du fournisseur");
        }
        return errors;
    }

}
