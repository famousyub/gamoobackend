package tn.rns.gmao.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.rns.gmao.handler.NotFoundException;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;
import tn.rns.gmao.repository.UserRepository;
import tn.rns.gmao.services.UserRoleService;
import tn.rns.gmao.services.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository,
                           UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public List<UserEntity> seedUsersAndUserRoles() {
        List<UserEntity> seededUsers = new ArrayList<>();

            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setRole(UserRoleEnum.USER);
            UserRoleEntity userRole = this.userRoleService.saveRole(userRoleEntity);
            UserRoleEntity userRoleEntity2 = new UserRoleEntity();
            userRoleEntity2.setRole(UserRoleEnum.ADMIN);
            UserRoleEntity adminRole = this.userRoleService.saveRole(userRoleEntity2);







            UserRoleEntity userRoleEntity3 = new UserRoleEntity();
            userRoleEntity3.setRole(UserRoleEnum.BUSINESS_USER);
            UserRoleEntity businessRole = this.userRoleService.saveRole(userRoleEntity3);
            //business_user

        return seededUsers;
    }




    @Override
    public UserEntity findUserById(Long userId) {
        Optional<UserEntity> byId = this.userRepository.findById(userId);
        if (byId.isPresent()) {
            return byId.get();
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(email);
        if (byEmail.isPresent()) {
            return byEmail.get();
        } else {
            return null;
        }
    }


    @Override
    public UserEntity findUserByUsername(String username) {
        Optional<UserEntity> byUsername = this.userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        } else {
            throw new NotFoundException("Can not find user with this username");
        }
    }

    @Override
    public boolean userExists(String username, String email) {
        Optional<UserEntity> byUsername = this.userRepository.findByUsername(username);
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(email);
        return byUsername.isPresent() || byEmail.isPresent();
    }

    @Override
    public void saveUserWithUpdatedPassword(UserEntity userEntity) {
        this.userRepository.save(userEntity);
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity user = findUserById(id);
        if (user == null) {
            return false;
        }



        userRepository.delete(user);
        return true;
    }



}
