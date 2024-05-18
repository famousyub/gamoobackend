package tn.rns.gmao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tn.rns.gmao.controller.api.RequestWorkApi;
import tn.rns.gmao.dto.RequestWorkDto;
import tn.rns.gmao.services.RequestWorkService;

import java.util.List;

@RestController
public class RequestWorkController implements RequestWorkApi {

    private RequestWorkService requestWorkService;

    @Autowired
    public RequestWorkController(
            RequestWorkService requestWorkService){
        this.requestWorkService = requestWorkService;
    }
    @Override
    public RequestWorkDto add(RequestWorkDto dto) {
       return  requestWorkService.add(dto);
    }

    @Override
    public RequestWorkDto findById(Integer idDT) {
        return requestWorkService.findById(idDT);
    }

    @Override
    public List<RequestWorkDto> findAll() {
        return requestWorkService.findAll();
    }

    @Override
    public void update(Integer idDT, RequestWorkDto dto) {
        requestWorkService.update(idDT,dto);
    }

    @Override
    public void delete(Integer idDT) {
        requestWorkService.delete(idDT);
    }
}
