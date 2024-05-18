package tn.rns.gmao.services.impl;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.FournisseurDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Fournisseur;
import tn.rns.gmao.repository.FournisseurRepository;
import tn.rns.gmao.services.FournisseurService;
import tn.rns.gmao.validator.FournisseurValidator;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImpl implements FournisseurService {

    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImpl(
            FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    @Override
    public FournisseurDto add(FournisseurDto dto) {
        List<String> errors = FournisseurValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le fournisseur n'est pas valide {}", dto);
            throw new InvalidEntityException("Le fournisseur n'est pas valide", ErrorCodes.FOURNISSEUR_NOT_VALID, errors);
        }

        Fournisseur fournisseurToAdd = FournisseurDto.toEntity(dto);
        fournisseurToAdd.setIdF(dto.getIdF());
        fournisseurRepository.save(fournisseurToAdd);

        return dto;
    }



    @Override
    public FournisseurDto findById(Integer idF) {
        if (idF == null) {
            log.error("L'ID du fournisseur est null");
            return null;
        }
        return fournisseurRepository.findById(idF).map(FournisseurDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun fournisseur avec l'ID = " + idF + " n' ete trouve dans la BDD",
                        ErrorCodes.FOURNISSEUR_NOT_FOUND)
        );
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll().stream()
                .map(FournisseurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idF, FournisseurDto dto) {
        checkIdFournisseur(idF);
        if (idF == null) {
            log.error("L'ID du fournisseur est null");
            throw new InvalidOperationException("Impossible de modifier le fournisseur un ID null",
                    ErrorCodes.FOURNISSEUR_NON_MODIFIABLE);
        }
        Optional<Fournisseur> fournisseurOptional = fournisseurRepository.findById(idF);
        if (fournisseurOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune fournisseur n'a ete trouve avec l'ID " + idF, ErrorCodes.FOURNISSEUR_NOT_FOUND);
        }
        Fournisseur fournisseurToSaved = fournisseurOptional.get();
        fournisseurToSaved.setIdF(dto.getIdF());
        fournisseurRepository.save(fournisseurToSaved);
    }

    private void checkIdFournisseur(Integer idF) {

        if (idF == null) {
            log.error(" ID fournisseur est null");
            throw new InvalidOperationException("Impossible de modifier le fournisseur avec un ID null",
                    ErrorCodes.FOURNISSEUR_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idF) {
        if (idF == null) {
            log.error("L'ID du fournisseur est null");
            return;
        }
        fournisseurRepository.deleteById(idF);
    }

}
