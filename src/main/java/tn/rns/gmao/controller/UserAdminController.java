package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.dto.BusinessRegisterDto;
import tn.rns.gmao.dto.UserDto;
import tn.rns.gmao.model.BusinessOwner;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;
import tn.rns.gmao.repository.UserRepository;
import tn.rns.gmao.repository.UserRoleRepository;
import tn.rns.gmao.services.FournisseurService;
import tn.rns.gmao.services.TechnicienOwnerService;
import tn.rns.gmao.services.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAdminController {


    @Autowired
    private FournisseurService fournisseurService ;

    @Autowired
    private TechnicienOwnerService technicienOwnerService;

    @Autowired
    private UserRepository userRepository ;

    @Autowired
    private UserService userService ;

    @Autowired
    private UserRoleRepository userRoleRepository;


    @PostMapping("/admin/add/tech")
    public ResponseEntity<?>  createUser(@RequestBody UserDto userDto)
    {
        UserEntity userEntity = UserDto.toEntity(userDto);

        UserRoleEntity userRoleEntity = userRoleRepository.findByRole(UserRoleEnum.TECHNICIEN).get();

        List<UserRoleEntity> roleEntities = new ArrayList<>();

        roleEntities.add(userRoleEntity);


         userEntity.setRoles(roleEntities);

         userEntity.setTechnicien(userDto.getEmail());
        userRepository.save(userEntity);
        return  ResponseEntity.ok().body(userEntity);

    }

    @PostMapping("/admin/add/fornisseur")
    public ResponseEntity<?> addTechnicient(@RequestBody BusinessRegisterDto businessRegisterDto)
    {
        if (this.technicienOwnerService.businessExists(businessRegisterDto.getBusinessName()) || this.userService.userExists(businessRegisterDto.getUsername(), businessRegisterDto.getEmail())) {
            throw new RuntimeException("Username or email address already in use.");
        }

        BusinessOwner businessOwner = this.technicienOwnerService.addTechnicien(businessRegisterDto);
        return new ResponseEntity<BusinessOwner>(businessOwner, HttpStatus.CREATED);
    }







}
