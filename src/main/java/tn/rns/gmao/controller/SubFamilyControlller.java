package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.MySubfamilyDto;
import tn.rns.gmao.dto.SubFamilyDto;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.model.SubFamily;
import tn.rns.gmao.repository.FamilyRepository;
import tn.rns.gmao.repository.SubFamilyRepository;
import tn.rns.gmao.services.SubFamilyService;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SubFamilyControlller {

    @Autowired
    private SubFamilyService subFamilyService;

    @Autowired
    private SubFamilyRepository subFamilyRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @PostMapping("/addsubfamily/{FamId}")
    ResponseEntity<?> creatsubfamily(@RequestBody MySubfamilyDto subFamilyDto, @PathVariable("FamId") Integer famId) {

        Family fam = familyRepository.findById(
                famId
        ).get();

        SubFamily subFamily = new SubFamily();
        subFamily.setNomSubFam(subFamilyDto.getNomSubFam());
        subFamily.setIdSubFam(
                subFamilyDto.getIdSubFam()
        );
        subFamily.setFamily(fam);
        SubFamily subFamilyDto1 = subFamilyRepository.save(subFamily);


        return ResponseEntity.ok().body(subFamilyDto);

    }


    @GetMapping("/allsubfamily")
    public ResponseEntity<?> allsubfamily() {

        List<SubFamily> subfamiliys = subFamilyRepository.findAll();

        return ResponseEntity.ok().body(subfamiliys);
    }


    @GetMapping("/subfamily/{idsubfamily}")
    public ResponseEntity<?> subfamilyone(@PathVariable("idsubfamily") Integer idsubfamily) {

        SubFamily subFamily = subFamilyRepository.findById(idsubfamily).get();

        return ResponseEntity.ok().body(subFamily);
    }
}
