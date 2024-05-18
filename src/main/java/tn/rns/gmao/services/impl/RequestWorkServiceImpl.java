package tn.rns.gmao.services.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.rns.gmao.dto.RequestWorkDto;
import tn.rns.gmao.exeption.EntityNotFoundException;
import tn.rns.gmao.exeption.ErrorCodes;
import tn.rns.gmao.exeption.InvalidEntityException;
import tn.rns.gmao.exeption.InvalidOperationException;
import tn.rns.gmao.model.RequestWork;
import tn.rns.gmao.repository.RequestWorkRepository;
import tn.rns.gmao.services.RequestWorkService;
import tn.rns.gmao.validator.RequestWorkValidator;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RequestWorkServiceImpl implements RequestWorkService {

    private RequestWorkRepository requestWorkRepository;

    @Autowired
    public RequestWorkServiceImpl(
            RequestWorkRepository requestWorkRepository) {
        this.requestWorkRepository = requestWorkRepository;
    }
    @Override
    public RequestWorkDto add(RequestWorkDto dto) {
        List<String> errors = RequestWorkValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La demande de travaux n'est pas valide {}", dto);
            throw new InvalidEntityException("La demande de travaux n'est pas valide", ErrorCodes.REQUEST_WORK_NOT_VALID, errors);
        }

        RequestWork RequestWorkToAdd = RequestWorkDto.toEntity(dto);
        RequestWorkToAdd.setIdDT(dto.getIdDT());
        requestWorkRepository.save(RequestWorkToAdd);

        return dto;
    }



    @Override
    public RequestWorkDto findById(Integer idDT) {
        if (idDT == null) {
            log.error("L'ID du demande de travaux est null");
            return null;
        }

        return requestWorkRepository.findById(idDT).map(RequestWorkDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune demande de travaux avec l'ID = " + idDT + " n' ete trouve dans la BDD",
                        ErrorCodes.REQUEST_WORK_NOT_FOUND)
        );
    }

    @Override
    public List<RequestWorkDto> findAll() {
        return requestWorkRepository.findAll().stream()
                .map(RequestWorkDto::fromEntity)
                .collect(Collectors.toList());
    }


    @Override
    public void update(Integer idDT, RequestWorkDto dto) {
        checkIdDT(idDT);
        if (idDT == null) {
            log.error("L'ID du demande de travaux est null");
            throw new InvalidOperationException("Impossible de modifier la demande de travaux un ID null",
                    ErrorCodes.REQUEST_WORK_NON_MODIFIABLE);
        }
        Optional<RequestWork> requestWorkOptional = requestWorkRepository.findById(idDT);
        if (requestWorkOptional.isEmpty()) {
            throw new EntityNotFoundException(
                    "Aucune demande de travaux n'a ete trouve avec l'ID " + idDT, ErrorCodes.REQUEST_WORK_NOT_FOUND);
        }
       RequestWork  requestWorkToSaved = requestWorkOptional.get();
        requestWorkToSaved.setIdDT(dto.getIdDT());
        requestWorkRepository.save(requestWorkToSaved);
    }

    private void checkIdDT(Integer idDT) {
        if (idDT == null) {
            log.error(" ID demande de travaux est null");
            throw new InvalidOperationException("Impossible de modifier la demande de travaux un ID null",
                    ErrorCodes.REQUEST_WORK_NON_MODIFIABLE);
        }
    }

    @Override
    public void delete(Integer idDT) {
        if (idDT == null) {
            log.error("L'ID du  demande de travaux  est null");
            return;
        }
        requestWorkRepository.deleteById(idDT);
    }
}
