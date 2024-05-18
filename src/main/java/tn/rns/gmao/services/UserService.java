package tn.rns.gmao.services;


import tn.rns.gmao.model.entities.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> seedUsersAndUserRoles();



    UserEntity findUserById(Long userId);

    UserEntity findUserByEmail(String email);

    boolean deleteUser(Long id);

   // BusinessOwner findBusinessOwnerById(Long id);

    UserEntity findUserByUsername(String username);

    boolean userExists(String username, String email);

    void saveUserWithUpdatedPassword(UserEntity userEntity);


}


