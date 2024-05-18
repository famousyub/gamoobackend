package tn.rns.gmao.services.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.FamilyDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.repository.FamilyRepository;
import tn.rns.gmao.services.FamilyService;
import tn.rns.gmao.validator.FamilyValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FamilyServiceImpl implements FamilyService {

    private FamilyRepository familyRepository;
    @Autowired
    public FamilyServiceImpl(
              FamilyRepository  familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public FamilyDto add(FamilyDto dto) {
        List<String> errors = FamilyValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La famille n'est pas valide {}", dto);
            throw new InvalidEntityException("La famille n'est pas valide", ErrorCodes.FAMILY_NOT_VALID, errors);
        }

        Family familyToAdd = FamilyDto.toEntity(dto);
        familyToAdd.setIdFam(dto.getIdFam());
        familyRepository.save(familyToAdd);

        return dto;
    }


    @Override
    public FamilyDto findById(Integer idFam) {
        if (idFam == null) {
            log.error("L'ID du famille est null");
            return null;
        }

        return familyRepository.findById(idFam).map(FamilyDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune famille avec l'ID = " + idFam + " n' ete trouve dans la BDD",
                        ErrorCodes.FAMILY_NOT_FOUND)
        );
    }

    @Override
    public List<FamilyDto> findAll() {
        return familyRepository.findAll().stream()
                .map(FamilyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idFam, FamilyDto dto) {
        checkIdFam(idFam);
        if (idFam == null) {
            log.error("L'ID du sous-famille est null");
            throw new InvalidOperationException("Impossible de modifier la sous-famille avec un ID null",
                    ErrorCodes.FAMILY_NON_MODIFIABLE);
        }
        Optional<Family> familyOptional = familyRepository.findById(idFam);
        if (familyOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune famille n'a ete trouve avec l'ID " + idFam, ErrorCodes.FAMILY_NOT_FOUND);
        }
        Family familyToSaved = familyOptional.get();
        familyToSaved.setIdFam(dto.getIdFam());
        familyRepository.save(familyToSaved);
    }

    private void checkIdFam(Integer idFam) {
        if (idFam == null) {
            log.error(" ID famille est null");
            throw new InvalidOperationException("Impossible de modifier la famille avec un ID null",
                    ErrorCodes.FAMILY_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idFam) {
        if (idFam == null) {
            log.error("L'ID du famille est null");
            return;
        }
        familyRepository.deleteById(idFam);
    }
}
