package tn.rns.gmao.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.rns.gmao.handler.NotFoundException;
import tn.rns.gmao.model.BusinessOwner;
import tn.rns.gmao.model.Instrument;
import tn.rns.gmao.repository.InstrumentRepository;
import tn.rns.gmao.services.InstrumentService;
import tn.rns.gmao.services.UserService;

import java.util.*;




@Service
@Transactional
public class InstrumentImplService implements InstrumentService {
    private final InstrumentRepository hobbyRepository;

    private final UserService userService;


    @Autowired
    public InstrumentImplService(InstrumentRepository hobbyRepository, UserService userService) {
        this.hobbyRepository = hobbyRepository;

        this.userService = userService;

    }

    @Override
    public Instrument findHobbieById(Long id) {
        Optional<Instrument> hobby = this.hobbyRepository.findById(id);
        if (hobby.isPresent()) {
            return hobby.get();
        } else {
            throw new NotFoundException("This hobby does not exist");
        }
    }

    @Override
    public void saveUpdatedHobby(Instrument hobby) throws Exception {

    }

    /*
    @Override
    public void saveUpdatedHobby(Instrument hobby) {
        Optional<Instrument> byId = this.hobbyRepository.findById(hobby.getId());
        if (byId.isPresent()) {
            deleteResourcesById(byId.get());
        }
        this.hobbyRepository.save(hobby);
    }
*/
    @Override
    public boolean deleteHobby(long id) throws Exception {
        return false;
    }

    @Override
    public Set<Instrument> findHobbyMatches(String username) {
        return null;
    }

    @Override
    public boolean saveHobbyForClient(Instrument hobby, String username) {
        return false;
    }

    @Override
    public boolean removeHobbyForClient(Instrument hobby, String username) {
        return false;
    }

    @Override
    public boolean isHobbySaved(Long hobbyId, String username) {
        return false;
    }

    @Override
    public Set<Instrument> getAllHobbiesForBusiness(String username) {
        return null;
    }

    @Override
    public Set<Instrument> getAllHobbieMatchesForClient(String username) {
        return null;
    }

  /*  @Override
    public boolean deleteHobby(long id) throws Exception {
        Optional<Instrument> byId = this.hobbyRepository.findById(id);
        if (byId.isPresent()) {
            deleteResourcesById(byId.get());
            BusinessOwner business = this.userService.findBusinessByUsername(byId.get().getCreator());
            business.getHobby_offers().remove(byId.get());
            this.userService.findAndRemoveHobbyFromClientsRecords(byId.get());
            this.hobbyRepository.deleteById(id);
            return true;
        }
        return false;
    }*/

    private void deleteResourcesById(Instrument byId) throws Exception {
        String profileImgId = byId.getProfileImg_id();
        String galleryImgId1 = byId.getGalleryImg1_id();
        String galleryImgId2 = byId.getGalleryImg2_id();
        String galleryImgId3 = byId.getGalleryImg3_id();


    }







    @Override
    public void createHobby(Instrument offer) {
        this.hobbyRepository.save(offer);
    }

}

