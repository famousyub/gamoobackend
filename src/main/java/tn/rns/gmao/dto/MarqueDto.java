package tn.rns.gmao.dto;


import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.model.Marque;

@Builder
@Data
public class MarqueDto {


    private Integer idMarque;

    private String nomMarque;

    public static MarqueDto fromEntity(Marque marque) {
        if (marque == null) {
            return null;
        }
        return MarqueDto.builder()
                .idMarque(marque.getIdMarque())
                .nomMarque(marque.getNomMarque())
                .build();
    }
    public static Marque toEntity(MarqueDto marqueDto) {
        if (marqueDto == null) {
            return null;
        }
        Marque marque = new Marque();
        marque.setIdMarque(marqueDto.getIdMarque());
        marque.setNomMarque(marqueDto.getNomMarque());
        return marque;
    }
}
