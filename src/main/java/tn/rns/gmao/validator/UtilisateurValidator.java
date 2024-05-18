package tn.rns.gmao.validator;

import org.springframework.util.StringUtils;
import tn.rns.gmao.dto.UtilisateurDto;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {
    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner le role d'utilisateur");
            return errors;
        }
        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMotpasse())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (!StringUtils.hasLength(String.valueOf(utilisateurDto.getRole())) || (utilisateurDto.getRole() != 'G' &&
                utilisateurDto.getRole() != 'T' && utilisateurDto.getRole() != 'S')) {
            errors.add("Le role d'utilisateur doit être G, T, ou S");
        }
        return errors;
    }
}
