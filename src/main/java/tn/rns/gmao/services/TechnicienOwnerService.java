package tn.rns.gmao.services;

import tn.rns.gmao.dto.BusinessRegisterDto;
import tn.rns.gmao.model.BusinessOwner;

public interface TechnicienOwnerService {


    BusinessOwner addTechnicien(BusinessRegisterDto businessRegisterDto) ;

    boolean businessExists(String businessName);
}
