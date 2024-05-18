package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import tn.rns.gmao.model.Utilisateur;

import java.util.Optional;


public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Integer> {


}
