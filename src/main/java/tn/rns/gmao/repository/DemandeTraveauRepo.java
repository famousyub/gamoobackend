package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.DemandeTraveau;

public interface  DemandeTraveauRepo extends JpaRepository<DemandeTraveau, Long> {

    Boolean existsByEmail(String email);
}
