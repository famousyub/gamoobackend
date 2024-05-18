package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Intervention;
import tn.rns.gmao.model.RequestWork;


import java.util.Date;

@Builder
@Data
public class RequestWorkDto {

    private Integer idDT;

    private String StatutDT;

    private Date dateDT;

    private String descriptionDT;

    private String affectation;

    public static RequestWorkDto fromEntity(RequestWork requestWork) {
        if (requestWork == null) {
            return null;
        }

        return RequestWorkDto.builder()
                .idDT(requestWork.getIdDT())
                .StatutDT(requestWork.getStatutDT())
                .dateDT(requestWork.getDateDT())
                .descriptionDT(requestWork.getDescriptionDT())
                .build();
    }
    public static RequestWork toEntity(RequestWorkDto dto) {
        if (dto == null) {
            return null;
        }
        RequestWork requestWork = new RequestWork();
        requestWork.setIdDT(dto.getIdDT());
        requestWork.setStatutDT(dto.getStatutDT());
        requestWork.setDateDT(dto.getDateDT());
        requestWork.setDescriptionDT(dto.getDescriptionDT());
        return requestWork;
    }
}
