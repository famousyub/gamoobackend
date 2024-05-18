package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Equipment;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.model.Speciality;

import java.util.List;

@Builder
@Data
public class SpecialityDto {

    private Integer idSpec;

    private String nomSpec;


    public static SpecialityDto fromEntity(Speciality speciality) {
        if (speciality == null) {
            return null;
        }
        return SpecialityDto.builder()
                .idSpec(speciality.getIdSpec())
                .nomSpec(speciality.getNomSpec())
                .build();
    }
    public static Speciality toEntity(SpecialityDto specialityDto) {
        if (specialityDto == null) {
            return null;
        }
       Speciality speciality = new Speciality();
        speciality.setIdSpec(specialityDto.getIdSpec());
        speciality.setNomSpec(specialityDto.getNomSpec());
        return speciality;
    }
}
