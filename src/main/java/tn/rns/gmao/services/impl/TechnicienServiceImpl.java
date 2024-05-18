package tn.rns.gmao.services.impl;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.TechnicienDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Technicien;
import tn.rns.gmao.repository.TechnicienRepository;
import tn.rns.gmao.services.TechnicienService;
import tn.rns.gmao.validator.TechnicienValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class TechnicienServiceImpl implements TechnicienService {


    private TechnicienRepository technicienRepository;
    @Autowired
    public TechnicienServiceImpl(
            TechnicienRepository technicienRepository) {
        this.technicienRepository = technicienRepository;
    }

    @Override
    public TechnicienDto add(TechnicienDto dto) {
        List<String> errors = TechnicienValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'equipement n'est pas valide {}", dto);
            throw new InvalidEntityException("L'equipement n'est pas valide", ErrorCodes.TECHNICIEN_NOT_VALID, errors);
        }
        Technicien technicienToAdd = TechnicienDto.toEntity(dto);
        technicienToAdd.setId(dto.getId());
        technicienRepository.save(technicienToAdd);

        return dto;
    }

    @Override
    public TechnicienDto findById(Integer id) {
            if (id == null) {
                log.error("L'ID du technicien est null");
                return null;
            }

            return technicienRepository.findById(id).map(TechnicienDto::fromEntity).orElseThrow(() ->
                    new EntityNotFoundException(
                            "Aucune technicien avec l'ID = " + id + " n' ete trouve dans la BDD",
                            ErrorCodes.TECHNICIEN_NOT_FOUND)
            );
    }

    @Override
    public List<TechnicienDto> findAll() {
        return technicienRepository.findAll().stream()
                .map(TechnicienDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void update(Integer id, TechnicienDto dto) {
        checkIdTechnicien(id);
        if (id == null) {
            log.error("L'ID du technicien est null");
            throw new InvalidOperationException("Impossible de modifier le technicien un ID null",
                    ErrorCodes.TECHNICIEN_NON_MODIFIABLE);
        }
        Optional<Technicien> technicienOptional = technicienRepository.findById(id);
        if (technicienOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune technicien n'a ete trouve avec l'ID " + id, ErrorCodes.TECHNICIEN_NOT_FOUND);
        }
        Technicien technicienToSaved = technicienOptional.get();
        technicienToSaved.setId(dto.getId());
        technicienRepository.save(technicienToSaved);
    }

    private void checkIdTechnicien(Integer id) {
        if (id == null) {
        log.error(" ID technicien est null");
        throw new InvalidOperationException("Impossible de modifier le technicien avec un ID null",
                ErrorCodes.TECHNICIEN_NON_MODIFIABLE);
    }
}

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("L'ID du technicien est null");
            return;
        }
        technicienRepository.deleteById(id);
    }


}
