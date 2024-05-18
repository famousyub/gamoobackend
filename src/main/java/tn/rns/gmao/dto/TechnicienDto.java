package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;

import tn.rns.gmao.model.Technicien;

import javax.persistence.Column;


@Builder
@Data
public class TechnicienDto {

    private Integer id;

    private String SpetialiteTech;

    private String TelTech;


    private String nom;


    private String prenom;


    private String Email;


    private String motpasse;


    private Character role;



    public static TechnicienDto fromEntity(Technicien technicien) {
        if (technicien == null) {
            return null;
        }

        return TechnicienDto.builder()
                .id(technicien.getId())
                .TelTech(technicien.getTelTech())
                .build();
    }
    public static Technicien toEntity(TechnicienDto dto) {
        if (dto == null) {
            return null;
        }
        Technicien technicien= new Technicien();
        technicien.setId(dto.getId());
        technicien.setTelTech(dto.getTelTech());
        return technicien;
    }
}
