package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rns.gmao.model.InterventionEntity;


@Repository
public interface InterventionentityRepository  extends JpaRepository<InterventionEntity,Long> {
}
