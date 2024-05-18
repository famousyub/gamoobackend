package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Technicien;

public interface TechnicienRepository extends JpaRepository<Technicien, Integer> {
}
