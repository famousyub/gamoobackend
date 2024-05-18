package tn.rns.gmao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.rns.gmao.model.BusinessOwner;

import java.util.Optional;


@Repository
public interface  BusnissRepository  extends JpaRepository<BusinessOwner, Long> {

    Optional<BusinessOwner> findByUsername(String username);

    Optional<BusinessOwner> findByBusinessName(String businessName);
}
