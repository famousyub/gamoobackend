package tn.rns.gmao.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusinessRegisterDto {


    private String username;
    private String businessName;
    private String address;
    private String email;
    private String password;

    private  String role ;

}
