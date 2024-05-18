package tn.rns.gmao.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.rns.gmao.dto.BusinessRegisterDto;
import tn.rns.gmao.model.BusinessOwner;
import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;
import tn.rns.gmao.repository.BusnissRepository;
import tn.rns.gmao.repository.UserRepository;
import tn.rns.gmao.services.TechnicienOwnerService;
import tn.rns.gmao.services.UserRoleService;
import tn.rns.gmao.services.UserService;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TechnicienOwnerServiceImpl implements TechnicienOwnerService {


    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    private final BusnissRepository businessOwnerRepository;
    private final UserRoleService userRoleService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TechnicienOwnerServiceImpl(ModelMapper modelMapper, UserRepository userRepository,

                                      BusnissRepository businessOwnerRepository, UserRoleService userRoleService, PasswordEncoder passwordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;

        this.businessOwnerRepository = businessOwnerRepository;
        this.userRoleService = userRoleService;
        this.passwordEncoder = passwordEncoder;

    }

   /* @Override
    public BusinessOwner addTechnicien(BusinessRegisterDto businessRegisterDto) {
        return null;
    }*/

    @Override
    public BusinessOwner addTechnicien(BusinessRegisterDto business) {
        UserRoleEntity businessUserRole = this.userRoleService.getUserRoleByEnumName(UserRoleEnum.BUSINESS_USER);
        BusinessOwner businessOwner = this.modelMapper.map(business, BusinessOwner.class);
        businessOwner.setRoles(List.of(businessUserRole));
        businessOwner.setTechnicien("technicien : " + business.getUsername());
        businessOwner.setPassword(this.passwordEncoder.encode(business.getPassword()));
        return businessOwnerRepository.save(businessOwner);
    }


    @Override
    public boolean businessExists(String businessName) {
        Optional<BusinessOwner> byBusinessName = this.businessOwnerRepository.findByBusinessName(businessName);
        return byBusinessName.isPresent();
    }
}
