package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.FournisseurDto;
import tn.rns.gmao.model.Fournisseur;
import tn.rns.gmao.repository.FournisseurRepository;
import tn.rns.gmao.services.FournisseurService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class OFourniseurController {

    @Autowired
    private FournisseurService fournisseurService ;

    @Autowired
    private FournisseurRepository fournisseurRepository;


    @PostMapping("/add/fournisseur")
    public ResponseEntity<?> createFournisseur(@RequestBody FournisseurDto fournisseurDto)
    {

              FournisseurDto fdto = fournisseurService.add(fournisseurDto);

              return  ResponseEntity.ok().body(fdto);


    }


    @GetMapping("/all/fournisseur")
    public  ResponseEntity<?> allfourniseur ()
    {


        List<Fournisseur> fournisseurs  = fournisseurRepository.findAll();

        return ResponseEntity.ok().body(fournisseurs);
    }


    @DeleteMapping("/fourniseur/{id}")

    public  ResponseEntity<?> deletefourniseeur(@PathVariable("id") Integer id)
    {

         fournisseurRepository.deleteById(id);

         return  ResponseEntity.ok().body("deleted");
    }
    @GetMapping("/fourniseur/{id}")
    public  ResponseEntity<?> onefourniseur(@PathVariable ("id") Integer idf)
    {

        Fournisseur fournisseur = fournisseurRepository.findById(idf).get() ;

        return  ResponseEntity.ok().body(fournisseur);
    }

    @PutMapping("/fourniseur/{id}")
    public  ResponseEntity<?> updatefournsieeur(@RequestBody FournisseurDto  fournisseurDto,@PathVariable("id") Integer id)
    {


         Fournisseur fdt = fournisseurRepository.findById(id).get();
          fdt.setEmailF(fournisseurDto.getEmailF());
          fdt.setAdresseF(fournisseurDto.getAdresseF());
          fdt.setNomF(fournisseurDto.getNomF());
          fdt.setTelF(fournisseurDto.getTelF());
          fdt.setMatriculeFiscale(fournisseurDto.getMatriculeFiscale());
          fdt.setPrenomF(fournisseurDto.getPrenomF());



          fournisseurRepository.save(fdt);

          return  ResponseEntity.ok().body(fdt);
    }
}
