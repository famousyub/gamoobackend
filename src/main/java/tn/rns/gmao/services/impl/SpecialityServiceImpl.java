package tn.rns.gmao.services.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.SpecialityDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Speciality;
import tn.rns.gmao.repository.SpecialityRepository;
import tn.rns.gmao.services.SpecialityService;
import tn.rns.gmao.validator.SpecialityValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SpecialityServiceImpl implements SpecialityService {


    private SpecialityRepository specialityRepository;
    @Autowired
    public SpecialityServiceImpl(
            SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public SpecialityDto add(SpecialityDto dto) {
        List<String> errors = SpecialityValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La specialite n'est pas valide {}", dto);
            throw new InvalidEntityException("La specialite n'est pas valide", ErrorCodes.SPECIALITY_NOT_VALID, errors);
        }

        Speciality specialityToAdd = SpecialityDto.toEntity(dto);

        specialityRepository.save(specialityToAdd);

        return dto;
    }


    @Override
    public SpecialityDto findById(Integer idSpec) {
        if (idSpec == null) {
            log.error("L'ID du specialte est null");
            return null;
        }

        return specialityRepository.findById(idSpec).map(SpecialityDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune specialite avec l'ID = " + idSpec + " n' ete trouve dans la BDD",
                        ErrorCodes.SPECIALITY_NOT_FOUND)
        );
    }

    @Override
    public List<SpecialityDto> findAll() {
        return specialityRepository.findAll().stream()
                .map(SpecialityDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idSpec, SpecialityDto dto) {
        checkIdSpec(idSpec);
        if (idSpec == null) {
            log.error("L'ID du speciality est null");
            throw new InvalidOperationException("Impossible de modifier la speciality un ID null",
                    ErrorCodes.SPECIALITY_NON_MODIFIABLE);
        }
        Optional<Speciality> specialityOptional = specialityRepository.findById(idSpec);
        if (specialityOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune speciality n'a ete trouve avec l'ID " + idSpec, ErrorCodes.SPECIALITY_NOT_FOUND);
        }
        Speciality specialityToSaved = specialityOptional.get();

        specialityRepository.save(specialityToSaved);
    }

    private void checkIdSpec(Integer idSpec) {
        if (idSpec == null) {
            log.error(" ID specialité est null");
            throw new InvalidOperationException("Impossible de modifier la speciality un ID null",
                    ErrorCodes.SPECIALITY_NON_MODIFIABLE);
        }
    }


    @Override
    public void delete(Integer idSpec) {
            if (idSpec == null) {
                log.error("L'ID du specialite est null");
                return;
            }
            specialityRepository.deleteById(idSpec);
        }
    }

