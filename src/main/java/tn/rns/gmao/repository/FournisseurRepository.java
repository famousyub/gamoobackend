package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Fournisseur;


public interface FournisseurRepository  extends JpaRepository<Fournisseur, Integer> {
}
