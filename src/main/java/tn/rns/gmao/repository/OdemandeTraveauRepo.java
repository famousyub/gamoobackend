package tn.rns.gmao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.rns.gmao.model.OdemandeTraveaux;

import java.util.Optional;


@Repository
public interface  OdemandeTraveauRepo extends JpaRepository<OdemandeTraveaux,Long> {

    //Page<OdemandeTraveaux> findByOGestionnaireId(Long postId, Pageable pageable);
    //Optional<OdemandeTraveaux> findByIdAndOGestionnaireId(Long id, Long postId);


    @Query("SELECT O from OdemandeTraveaux O  WHERE O.OGestionnaire.id =?1")
    Page<OdemandeTraveaux> findByOGestionnaireId(Long postId, Pageable pageable);


    @Query("SELECT O from OdemandeTraveaux O  WHERE  O.id=?1 AND    O.OGestionnaire.id =?2 ")
    Optional<OdemandeTraveaux> findByIdAndOGestionnaireId(Long id, Long postId);

}
