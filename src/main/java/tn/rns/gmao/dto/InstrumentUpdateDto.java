package tn.rns.gmao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class  InstrumentUpdateDto {


    private Long id;
    private String name;
    private String slogan;
    private String intro;
    private String description;

    private String creator;
    private BigDecimal price;

    private String contactInfo;
    private String profileImgUrl;
    private String galleryImgUrl1;
    private String galleryImgUrl2;
    private String galleryImgUrl3;
    private String profileImg_id;
    private String galleryImg1_id;
    private String galleryImg2_id;
    private String galleryImg3_id;


}