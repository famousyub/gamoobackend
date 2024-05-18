package tn.rns.gmao.model.entities;


import tn.rns.gmao.model.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRoleEntity extends BaseEntity {
    private UserRoleEnum role;

    @Enumerated(EnumType.STRING)
    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}
