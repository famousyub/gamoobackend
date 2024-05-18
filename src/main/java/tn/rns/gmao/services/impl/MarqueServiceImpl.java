package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.MarqueDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.Marque;
import tn.rns.gmao.repository.MarqueRepository;
import tn.rns.gmao.services.MarqueService;
import tn.rns.gmao.validator.MarqueValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class MarqueServiceImpl implements MarqueService {

    private MarqueRepository marqueRepository;
    @Autowired
    public MarqueServiceImpl(
           MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    @Override
    public MarqueDto add(MarqueDto dto) {
        List<String> errors = MarqueValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La marque n'est pas valide {}", dto);
            throw new InvalidEntityException("La marque n'est pas valide", ErrorCodes.MARQUE_NOT_VALID, errors);
        }

        Marque marqueToAdd = MarqueDto.toEntity(dto);
        marqueToAdd.setIdMarque(dto.getIdMarque());
        marqueRepository.save(marqueToAdd);

        return dto;
    }


    @Override
    public MarqueDto findById(Integer idMarque) {
        if (idMarque == null) {
            log.error("L'ID du marque est null");
            return null;
        }

        return marqueRepository.findById(idMarque).map(MarqueDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune marque avec l'ID = " + idMarque + " n' ete trouve dans la BDD",
                        ErrorCodes.MARQUE_NOT_FOUND)
        );
    }

    @Override
    public List<MarqueDto> findAll() {
        return marqueRepository.findAll().stream()
                .map(MarqueDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void update(Integer idMarque, MarqueDto dto) {
        checkIdMarque(idMarque);
        if (idMarque == null) {
            log.error("L'ID du marque est null");
            throw new InvalidOperationException("Impossible de modifier la marque un ID null",
                    ErrorCodes.MARQUE_NON_MODIFIABLE);
        }
        Optional<Marque> marqueOptional = marqueRepository.findById(idMarque);
        if (marqueOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune marque n'a ete trouve avec l'ID " + idMarque, ErrorCodes.MARQUE_NOT_FOUND);
        }
        Marque marqueToSaved = marqueOptional.get();
        marqueToSaved.setIdMarque(dto.getIdMarque());
        marqueRepository.save(marqueToSaved);
    }

    private void checkIdMarque(Integer idMarque) {
        if (idMarque == null) {
            log.error(" ID marque est null");
            throw new InvalidOperationException("Impossible de modifier la marque avec un ID null",
                    ErrorCodes.MARQUE_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idMarque) {
        if (idMarque == null) {
            log.error("L'ID du marque est null");
            return;
        }
        marqueRepository.deleteById(idMarque);
    }
}
