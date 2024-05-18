package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.RequestWork;
import tn.rns.gmao.model.Surveillant;

import java.util.List;

@Builder
@Data
public class SurveillantDto {

    private Integer id;

    private List<RequestWork> RequestWork;

    public static SurveillantDto fromEntity(Surveillant surveillant) {
        if (surveillant == null) {
            return null;
        }
        return SurveillantDto.builder()
                .id(surveillant.getId())
                .build();
    }
        public static Surveillant toEntity(SurveillantDto dto) {
            if (dto == null) {
                return null;
            }
            Surveillant surveillant= new Surveillant();
            surveillant.setId(dto.getId());
            return surveillant;
        }
}
