package tn.rns.gmao.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.rns.gmao.model.Utilisateur;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.model.entities.UserRoleEntity;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private  Long id ;

    private String username;
    private String email;




    private String password;

    private String role ;





    public static UserDto fromEntity(UserEntity utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UserDto.builder()
                .id(utilisateur.getId())
                .username(utilisateur.getUsername())

                .email(utilisateur.getEmail())
                .password(utilisateur.getPassword())
                .role(utilisateur.getRole())

                .build();
    }
    public static UserEntity toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        UserEntity utilisateur = new UserEntity();
        utilisateur.setId(dto.getId());
        utilisateur.setUsername(dto.getUsername());
        utilisateur.setPassword(dto.getPassword());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setRole(dto.getRole());

        return utilisateur;
    }
}
