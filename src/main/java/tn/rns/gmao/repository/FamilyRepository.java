package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.rns.gmao.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {
}
