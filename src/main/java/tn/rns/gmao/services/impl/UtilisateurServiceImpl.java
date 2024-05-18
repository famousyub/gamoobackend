package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.UtilisateurDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Utilisateur;
import tn.rns.gmao.repository.UtilisateurRepository;
import tn.rns.gmao.services.UtilisateurService;
import tn.rns.gmao.validator.UtilisateurValidator;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private UtilisateurRepository utilisateurRepository;


    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository
                                 ) {
        this.utilisateurRepository = utilisateurRepository;

    }


    @Override
    public UtilisateurDto add(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur n'est pas valide {}", dto);
            throw new InvalidEntityException("Utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        Utilisateur utilisateurToAdd = UtilisateurDto.toEntity(dto);
        utilisateurToAdd.setId(dto.getId());
        utilisateurRepository.save(utilisateurToAdd);

        return dto;
    }


    @Override
    public UtilisateurDto findById(Integer id) {
        if (id == null) {
            log.error("Utilisateur ID est null");
            return null;
        }
        return utilisateurRepository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return utilisateurRepository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void update(Integer id, UtilisateurDto dto) {
        checkIdU(id);
        if (id == null) {
            log.error("L'ID utilisateur est null");
            throw new InvalidOperationException("Impossible de modifier l'utilisateur un ID null",
                    ErrorCodes.UTILISATEUR_NON_MODIFIABLE);
        }
        Optional<Utilisateur> utilisateurOptional = utilisateurRepository.findById(id);
        if (utilisateurOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune utilisateur n'a ete trouve avec l'ID " + id, ErrorCodes.UTILISATEUR_NOT_FOUND);
        }
        Utilisateur utilisateurToSaved = utilisateurOptional.get();
        utilisateurToSaved.setId(dto.getId());
        utilisateurRepository.save(utilisateurToSaved);
    }

    private void checkIdU(Integer id) {
        if (id == null) {
            log.error(" ID utilisateur est null");
            throw new InvalidOperationException("Impossible de modifier l'utilisateur' avec un ID null",
                    ErrorCodes.UTILISATEUR_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer id) {
            if (id == null) {
                log.error("Utilisateur ID est null");
                return;
            }
            utilisateurRepository.deleteById(id);
    }





}