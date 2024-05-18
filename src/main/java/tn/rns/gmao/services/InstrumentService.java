package tn.rns.gmao.services;

import tn.rns.gmao.model.Instrument;

import java.util.List;
import java.util.Set;

public interface InstrumentService {



    Instrument findHobbieById(Long id);

    void saveUpdatedHobby(Instrument hobby) throws Exception;

    boolean deleteHobby(long id) throws Exception;

    Set<Instrument> findHobbyMatches(String username);

    boolean saveHobbyForClient(Instrument hobby, String username);

    boolean removeHobbyForClient(Instrument hobby, String username);

    boolean isHobbySaved(Long hobbyId, String username);



    Set<Instrument> getAllHobbiesForBusiness(String username);

    Set<Instrument> getAllHobbieMatchesForClient(String username);

    void createHobby(Instrument offer);
}
