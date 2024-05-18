package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.SubFamilyDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.SubFamily;
import tn.rns.gmao.repository.SubFamilyRepository;
import tn.rns.gmao.services.SubFamilyService;
import tn.rns.gmao.validator.SubFamilyValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubFamilyServiceImpl implements SubFamilyService {

    private SubFamilyRepository subFamilyRepository;
    @Autowired
    public SubFamilyServiceImpl(
          SubFamilyRepository subFamilyRepository) {
        this.subFamilyRepository = subFamilyRepository;
    }

    @Override
    public SubFamilyDto add(SubFamilyDto dto) {
        List<String> errors = SubFamilyValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La sous-famille n'est pas valide {}", dto);
            throw new InvalidEntityException("La sous-famille n'est pas valide", ErrorCodes.SUBFAMILY_NOT_VALID, errors);
        }

        SubFamily subFamilyToAdd = SubFamilyDto.toEntity(dto);
        subFamilyToAdd.setIdSubFam(dto.getIdSubFam());
        subFamilyRepository.save(subFamilyToAdd);

        return dto;
    }



    @Override
    public SubFamilyDto findById(Integer idSubFam) {
        if (idSubFam == null) {
            log.error("L'ID du sous-famille est null");
            return null;
        }

        return subFamilyRepository.findById(idSubFam).map(SubFamilyDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune sous-famille avec l'ID = " + idSubFam + " n' ete trouve dans la BDD",
                        ErrorCodes.SUBFAMILY_NOT_FOUND)
        );
    }

    @Override
    public List<SubFamilyDto> findAll() {
        return subFamilyRepository.findAll().stream()
                .map(SubFamilyDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idSubFam, SubFamilyDto dto) {
        checkIdSubFam(idSubFam);
        if (idSubFam == null) {
            log.error("L'ID du sous-famille est null");
            throw new InvalidOperationException("Impossible de modifier la sous-famille avec un ID null",
                    ErrorCodes.SUBFAMILY_NON_MODIFIABLE);
        }
        Optional<SubFamily> subFamilyOptional = subFamilyRepository.findById(idSubFam);
        if (subFamilyOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune sous-famille n'a ete trouve avec l'ID " + idSubFam, ErrorCodes.SUBFAMILY_NOT_FOUND);
        }
        SubFamily subFamilyToSaved = subFamilyOptional.get();
        subFamilyToSaved.setIdSubFam(dto.getIdSubFam());
        subFamilyRepository.save(subFamilyToSaved);
    }

    private void checkIdSubFam(Integer idSubFam) {
        if (idSubFam == null) {
            log.error(" ID sous-famille est null");
            throw new InvalidOperationException("Impossible de modifier la sous-famille avec un ID null",
                    ErrorCodes.SUBFAMILY_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idSubFam) {
        if (idSubFam == null) {
            log.error("L'ID du sous-famille est null");
            return;
        }
        subFamilyRepository.deleteById(idSubFam);
    }
}

