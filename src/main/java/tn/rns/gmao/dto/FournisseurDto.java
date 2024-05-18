package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Fournisseur;

@Builder
@Data
public class FournisseurDto {

    private Integer idF;

    private String nomF;

    private String prenomF;

    private String adresseF;

    private String TelF;

    private String EmailF;

    private String matriculeFiscale;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .idF(fournisseur.getIdF())
                .nomF(fournisseur.getNomF())
                .prenomF(fournisseur.getPrenomF())
                .adresseF(fournisseur.getAdresseF())
                .TelF(fournisseur.getTelF())
                .EmailF(fournisseur.getEmailF())
                .matriculeFiscale(fournisseur.getMatriculeFiscale())
                .build();
    }
    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdF(dto.getIdF());
        fournisseur.setNomF(dto.getNomF());
        fournisseur.setPrenomF(dto.getPrenomF());
        fournisseur.setAdresseF(dto.getAdresseF());
        fournisseur.setEmailF(dto.getEmailF());
        fournisseur.setTelF(dto.getTelF());
        fournisseur.setMatriculeFiscale(dto.getMatriculeFiscale());
        return fournisseur;
    }
}
