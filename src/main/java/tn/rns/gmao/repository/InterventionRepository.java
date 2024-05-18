package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Intervention;


public interface InterventionRepository extends JpaRepository<Intervention, Integer> {
}
