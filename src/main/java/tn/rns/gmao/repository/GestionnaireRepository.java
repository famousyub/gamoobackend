package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Gestionnaire;


public interface GestionnaireRepository  extends JpaRepository<Gestionnaire, Integer> {
}
