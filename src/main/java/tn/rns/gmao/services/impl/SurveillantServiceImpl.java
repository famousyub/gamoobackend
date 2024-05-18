package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.SurveillantDto;
import tn.rns.gmao.dto.TechnicienDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Surveillant;
import tn.rns.gmao.model.Technicien;
import tn.rns.gmao.repository.SurveillantRepository;
import tn.rns.gmao.services.SurveillantService;
import tn.rns.gmao.validator.SurveillantValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SurveillantServiceImpl implements SurveillantService {

    private SurveillantRepository surveillantRepository;
    @Autowired
    public SurveillantServiceImpl(
            SurveillantRepository surveillantRepository) {
        this.surveillantRepository = surveillantRepository;
    }


    @Override
    public SurveillantDto add(SurveillantDto dto) {
        List<String> errors = SurveillantValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le surveillant n'est pas valide {}", dto);
            throw new InvalidEntityException("Le surveillant n'est pas valide", ErrorCodes.SURVEILLANT_NOT_VALID, errors);
        }
        Surveillant surveillantToAdd = SurveillantDto.toEntity(dto);
        surveillantToAdd.setId(dto.getId());
        surveillantRepository.save(surveillantToAdd);

        return dto;
    }

    @Override
    public SurveillantDto findById(Integer id) {
        if (id == null) {
            log.error("L'ID du surveillant est null");
            return null;
        }

        return surveillantRepository.findById(id).map(SurveillantDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune surveillant avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.SURVEILLANT_NOT_FOUND)
        );
    }

    @Override
    public List<SurveillantDto> findAll() {
        return surveillantRepository.findAll().stream()
                .map(SurveillantDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, SurveillantDto dto) {
        checkIdSurveillant(id);
        if (id == null) {
            log.error("L'ID du surveillant est null");
            throw new InvalidOperationException("Impossible de modifier le surveillant un ID null",
                    ErrorCodes.SURVEILLANT_NON_MODIFIABLE);
        }
        Optional<Surveillant> surveillantOptional = surveillantRepository.findById(id);
        if (surveillantOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune surveillant n'a ete trouve avec l'ID " + id, ErrorCodes.SURVEILLANT_NOT_FOUND);
        }
        Surveillant surveillantToSaved = surveillantOptional.get();
        surveillantToSaved.setId(dto.getId());
        surveillantRepository.save(surveillantToSaved);
    }

    private void checkIdSurveillant(Integer id) {
        if (id == null) {
            log.error(" ID surveillant est null");
            throw new InvalidOperationException("Impossible de modifier le surveillant avec un ID null",
                    ErrorCodes.SURVEILLANT_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("L'ID du surveillant est null");
            return;
        }
        surveillantRepository.deleteById(id);
    }
}
