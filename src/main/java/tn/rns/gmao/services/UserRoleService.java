package tn.rns.gmao.services;


import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;

public interface UserRoleService {
    UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum);

    UserRoleEntity saveRole(UserRoleEntity userRoleEntity);
}
