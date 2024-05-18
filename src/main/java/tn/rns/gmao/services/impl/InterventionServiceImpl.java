package tn.rns.gmao.services.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.InterventionDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Intervention;
import tn.rns.gmao.repository.InterventionRepository;
import tn.rns.gmao.services.InterventionService;
import tn.rns.gmao.validator.InterventionValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InterventionServiceImpl implements InterventionService {

    private InterventionRepository interventionRepository;
    @Autowired
    public InterventionServiceImpl(
            InterventionRepository  interventionRepository) {
        this.interventionRepository = interventionRepository;
    }


    @Override
    public InterventionDto add(InterventionDto dto) {
        List<String> errors = InterventionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'intervention  n'est pas valide {}", dto);
            throw new InvalidEntityException("L'intervention n'est pas valide", ErrorCodes.INTERVENTION_NOT_VALID, errors);
        }

       Intervention interventionToAdd = InterventionDto.toEntity(dto);
        interventionToAdd.setIdInter(dto.getIdInter());
        interventionRepository.save(interventionToAdd);

        return dto;
    }


    @Override
    public InterventionDto findById(Integer idInter) {
        if (idInter == null) {
            log.error("L'ID d'intervention' est null");
            return null;
        }

        return interventionRepository.findById(idInter).map(InterventionDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune intervention avec l'ID = " + idInter + " n' ete trouve dans la BDD",
                        ErrorCodes.INTERVENTION_NOT_FOUND)
        );
    }

    @Override
    public List<InterventionDto> findAll() {
        return interventionRepository.findAll().stream()
                .map(InterventionDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idInter, InterventionDto dto) {
        checkIdInter(idInter);
        if (idInter == null) {
            log.error("L'ID d'intervention est null");
            throw new InvalidOperationException("Impossible de modifier l'intervention un ID null",
                    ErrorCodes.INTERVENTION_NON_MODIFIABLE);
        }
        Optional<Intervention> interventionOptional = interventionRepository.findById(idInter);
        if (interventionOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune intervention n'a ete trouve avec l'ID " + idInter, ErrorCodes.INTERVENTION_NOT_FOUND);
        }
        Intervention interventionToSaved = interventionOptional.get();
        interventionToSaved.setIdInter(dto.getIdInter());
        interventionRepository.save(interventionToSaved);
    }

    private void checkIdInter(Integer idInter) {
        if (idInter == null) {
            log.error(" ID intervention est null");
            throw new InvalidOperationException("Impossible de modifier l'intervention avec un ID null",
                    ErrorCodes.INTERVENTION_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idInter) {
        if (idInter == null) {
            log.error("L'ID d'intervention est null");
            return;
        }
        interventionRepository.deleteById(idInter);
    }

}
