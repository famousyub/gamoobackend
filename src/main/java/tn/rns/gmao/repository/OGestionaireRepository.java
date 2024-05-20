package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rns.gmao.model.OGestionnaire;


@Repository
public interface  OGestionaireRepository  extends JpaRepository<OGestionnaire,Long> {
}
