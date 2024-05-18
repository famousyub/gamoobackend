package tn.rns.gmao.dto;

import lombok.Builder;
import lombok.Data;
import tn.rns.gmao.model.*;

import java.util.Date;
import java.util.List;

@Builder
@Data
public class EquipmentDto {

    private Integer idEq;

    private String numserieEq ;

    private String nomEq;

    private Date dateachatEq;

    private String statutEq;

    private Double prix;

    private Boolean mobility;

    private String type;

    private String FonctionEq;

    private Marque Marque;

    private Fournisseur Fournisseur;

    private List <Technicien>Technicien;

    private List<RequestWork> RequestWork;

    private List<Intervention> Intervention;

    private SubFamily SubFamily ;

    public static EquipmentDto fromEntity(Equipment equipment) {
        if (equipment == null) {
            return null;
        }
        return EquipmentDto.builder()
                .idEq(equipment.getIdEq())
                .numserieEq(equipment.getNumserieEq())
                .nomEq(equipment.getNomEq())
                .dateachatEq(equipment.getDateachatEq())
                .statutEq(equipment.getStatutEq())
                .prix(equipment.getPrix())
                .mobility(equipment.getMobility())
                .type(equipment.getType())
                .FonctionEq(equipment.getFonctionEq())
                .build();
    }
    public static Equipment toEntity(EquipmentDto equipmentDto) {
        if (equipmentDto== null) {
            return null;
        }
        Equipment equipment = new Equipment();
        equipment.setIdEq(equipmentDto.getIdEq());
        equipment.setNumserieEq(equipmentDto.getNumserieEq());
        equipment.setDateachatEq(equipmentDto.getDateachatEq());
        equipment.setStatutEq(equipmentDto.getStatutEq());
        equipment.setPrix(equipmentDto.getPrix());
        equipment.setMobility(equipmentDto.getMobility());
        equipment.setType(equipmentDto.getType());
        equipment.setFonctionEq(equipmentDto.getFonctionEq());
        return equipment;
    }
}
