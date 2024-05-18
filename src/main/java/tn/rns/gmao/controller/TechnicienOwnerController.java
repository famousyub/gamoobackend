package tn.rns.gmao.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.*;
import tn.rns.gmao.model.BusinessOwner;
import tn.rns.gmao.model.Family;
import tn.rns.gmao.model.Intervention;
import tn.rns.gmao.model.InterventionEntity;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.repository.*;
import tn.rns.gmao.services.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TechnicienOwnerController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecialityRepository specialityRepository ;



    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private MarqueService marqueService ;


    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private InterventionentityRepository interventionRepository;

    @Autowired
    private FamilyService familyService ;

    @Autowired
    private FamilyRepository familyRepository;


    @Autowired
    private TechnicienOwnerService technicienOwnerService ;



    @PostMapping("/add/intervention")

    public  ResponseEntity<?> createInervention(@RequestBody InterventionEntityDto interventionDto)
    {
        InterventionEntity interventi_  =InterventionEntityDto.toEntity(interventionDto);

        interventionRepository.save(interventi_);

        return  ResponseEntity.ok().body(interventi_);
    }


    @GetMapping("/all/intervention")
    public  ResponseEntity<?> alllintervention()
    {

        List<InterventionEntity> allintervention  = interventionRepository.findAll();
        return  ResponseEntity.ok().body(allintervention);
    }
    @PostMapping("/add/family")

    public  ResponseEntity<?> createFamily (@RequestBody FamilyDto familyDto)
    {
        FamilyDto fd = familyService.add(familyDto);

        return  ResponseEntity.ok().body(fd);
    }
    @GetMapping("/all/family")
    public  ResponseEntity<?> allfamily()
    {

        List<Family> familys  = familyRepository.findAll();

        return  ResponseEntity.ok().body(familys);
    }
     @PostMapping("/add/speciality")

     public  ResponseEntity<?> addspeciality (@RequestBody SpecialityDto specialityDto)
     {

         SpecialityDto sd =    specialityService.add(specialityDto);

         return  ResponseEntity.ok().body(sd);

     }


    @PostMapping("/add/marque")

    public  ResponseEntity<?> addsmarque (@RequestBody MarqueDto specialityDto)
    {

        MarqueDto sd =    marqueService.add(specialityDto);

        return  ResponseEntity.ok().body(sd);

    }

     @GetMapping("/all/speciality")

     public ResponseEntity<?> allspeciality ()
     {

         return  ResponseEntity.ok().body( specialityRepository.findAll() );
     }


    @GetMapping("/all/marques")

    public ResponseEntity<?> allmarques ()
    {

        return  ResponseEntity.ok().body( marqueRepository.findAll() );
    }

    @PostMapping("/add/technicien")
    public ResponseEntity<?> addTechnicient(@RequestBody BusinessRegisterDto businessRegisterDto)
    {
        if (this.technicienOwnerService.businessExists(businessRegisterDto.getBusinessName()) || this.userService.userExists(businessRegisterDto.getUsername(), businessRegisterDto.getEmail())) {
            throw new RuntimeException("Username or email address already in use.");
        }

        BusinessOwner businessOwner = this.technicienOwnerService.addTechnicien(businessRegisterDto);
        return new ResponseEntity<BusinessOwner>(businessOwner, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<?> allusers()
    {


        List<UserEntity> users = userRepository.findAll();
        return  ResponseEntity.ok().body(users);

    }

   @GetMapping("/user/{id}")

   public ResponseEntity<?> usersbuyis(@PathVariable("id") Long id)
   {


       UserEntity users = userRepository.findById(id).get();
       return  ResponseEntity.ok().body(users);

   }








    }

