package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.GestionnaireDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Gestionnaire;
import tn.rns.gmao.repository.GestionnaireRepository;
import tn.rns.gmao.services.GestionnaireService;
import tn.rns.gmao.validator.GestionnaireValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GestionnaireServiceImpl implements GestionnaireService {

    private GestionnaireRepository gestionnaireRepository;
    @Autowired
    public GestionnaireServiceImpl(
            GestionnaireRepository gestionnaireRepository) {
        this.gestionnaireRepository = gestionnaireRepository;
    }

    @Override
    public GestionnaireDto add(GestionnaireDto dto) {
        List<String> errors = GestionnaireValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le gestionnaire n'est pas valide {}", dto);
            throw new InvalidEntityException("Le gestionnaire n'est pas valide", ErrorCodes.GESTIONNAIRE_NOT_VALID, errors);
        }
        Gestionnaire gestionnaireToAdd = GestionnaireDto.toEntity(dto);
        gestionnaireToAdd.setId(dto.getId());
        gestionnaireRepository.save(gestionnaireToAdd);

        return dto;
    }

    @Override
    public GestionnaireDto findById(Integer id) {
        if (id == null) {
            log.error("L'ID du gestionnaire est null");
            return null;
        }

        return gestionnaireRepository.findById(id).map(GestionnaireDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune gestionnaire avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.GESTIONNAIRE_NOT_FOUND)
        );
    }

    @Override
    public List<GestionnaireDto> findAll() {
        return gestionnaireRepository.findAll().stream()
                .map(GestionnaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer id, GestionnaireDto dto) {
        checkIdGestionnaire(id);
        if (id == null) {
            log.error("L'ID du gestionnaire est null");
            throw new InvalidOperationException("Impossible de modifier le gestionnaire un ID null",
                    ErrorCodes.GESTIONNAIRE_NON_MODIFIABLE);
        }
        Optional<Gestionnaire> gestionnaireOptional = gestionnaireRepository.findById(id);
        if (gestionnaireOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune gestionnaire n'a ete trouve avec l'ID " + id, ErrorCodes.GESTIONNAIRE_NOT_FOUND);
        }
       Gestionnaire gestionnaireToSaved = gestionnaireOptional.get();
        gestionnaireToSaved.setId(dto.getId());
        gestionnaireRepository.save(gestionnaireToSaved);
    }

    private void checkIdGestionnaire(Integer id) {
        if (id == null) {
            log.error(" ID gestionnaire est null");
            throw new InvalidOperationException("Impossible de modifier le gestionnaire avec un ID null",
                    ErrorCodes.GESTIONNAIRE_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer id) {
        if (id== null) {
            log.error("L'ID du gestionnaire est null");
            return;
        }
        gestionnaireRepository.deleteById(id);

    }
}
