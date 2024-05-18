package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Surveillant;

public interface SurveillantRepository extends JpaRepository<Surveillant, Integer> {
}
