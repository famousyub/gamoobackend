package tn.rns.gmao.services.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.handler.NotFoundException;
import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;
import tn.rns.gmao.repository.UserRoleRepository;
import tn.rns.gmao.services.UserRoleService;

import java.util.Optional;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleEntity getUserRoleByEnumName(UserRoleEnum userRoleEnum) {
        Optional<UserRoleEntity> byRole = this.userRoleRepository.findByRole(userRoleEnum);
        if (byRole.isPresent()) {
            return byRole.get();
        } else {
            throw new NotFoundException("User role not found. Please seed the roles.");
        }
    }

    @Override
    public UserRoleEntity saveRole(UserRoleEntity userRoleEntity) {
        return this.userRoleRepository.save(userRoleEntity);
    }
}
