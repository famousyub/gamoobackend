package tn.rns.gmao.dto;


import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Utilisateur;

import java.util.stream.Collectors;

@Builder
@Data
public class UtilisateurDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String Email;

    private String motpasse;

    private Character role;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .Email(utilisateur.getEmail())
                .motpasse(utilisateur.getMotpasse())
                .role(utilisateur.getRole())
                .build();
    }
    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMotpasse(dto.getMotpasse());
        utilisateur.setRole(dto.getRole());
        return utilisateur;
    }
}
