package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rns.gmao.model.Instrument;

import java.util.List;
import java.util.Set;

@Repository
public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Set<Instrument> findAllByCreator(String creator);


}
