package tn.rns.gmao.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.rns.gmao.dto.UserDto;
import tn.rns.gmao.model.entities.UserEntity;
import tn.rns.gmao.model.entities.UserRoleEntity;
import tn.rns.gmao.model.enums.UserRoleEnum;
import tn.rns.gmao.model.jwt.JwtRequest;
import tn.rns.gmao.model.jwt.JwtResponse;
import tn.rns.gmao.repository.UserRepository;
import tn.rns.gmao.repository.UserRoleRepository;
import tn.rns.gmao.security.HobbieUserDetailsService;
import tn.rns.gmao.services.UserService;
import tn.rns.gmao.utility.JWTUtility;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    private  final UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    private final JWTUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    private final HobbieUserDetailsService hobbieUserDetailsService;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder, UserRepository userRepository ,  JWTUtility jwtUtility, AuthenticationManager authenticationManager, HobbieUserDetailsService hobbieUserDetailsService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
         this.userRepository = userRepository;
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
        this.hobbieUserDetailsService = hobbieUserDetailsService;
    }

    /*@PostMapping("/signup")
    @Operation(summary = "Create new client-user")
    public ResponseEntity<?> signup(@RequestBody AppClientSignUpDto user) {
        System.out.println(user);
        if (this.userService.userExists(user.getUsername(), user.getEmail())) {
            throw new RuntimeException("Username or email address already in use.");
        }
        AppClient client = this.userService.register(user);
        return new ResponseEntity<AppClient>(client, HttpStatus.CREATED);
    }

    @PostMapping("/register")
    @Operation(summary = "Create new business-user")
    public ResponseEntity<?> registerBusiness(@RequestBody BusinessRegisterDto business) {
        if (this.userService.businessExists(business.getBusinessName()) || this.userService.userExists(business.getUsername(), business.getEmail())) {
            throw new RuntimeException("Username or email address already in use.");
        }
        BusinessOwner businessOwner = this.userService.registerBusiness(business);
        return new ResponseEntity<BusinessOwner>(businessOwner, HttpStatus.CREATED);
    }

    @GetMapping("/client")
    @Operation(summary = "show client-user information", security = @SecurityRequirement(name = "bearerAuth"))
    public AppClient showUserDetails(@RequestParam String username) {
        return this.userService.findAppClientByUsername(username);
    }

    @GetMapping("/business")
    @Operation(summary = "Show business-user information", security = @SecurityRequirement(name = "bearerAuth"))
    public BusinessOwner showBusinessDetails(@RequestParam String username) {
        return this.userService.findBusinessByUsername(username);
    }

    @PutMapping("/user")
    @Operation(summary = "Update client-user information (use existing user id)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> updateUser(@RequestBody UpdateAppClientDto user) {
        AppClient client = this.userService.findAppClientById(user.getId());
        client.setPassword(this.passwordEncoder.encode(user.getPassword()));
        client.setGender(user.getGender());
        client.setFullName(user.getFullName());
        this.userService.saveUpdatedUserClient(client);
        return new ResponseEntity<AppClient>(client, HttpStatus.CREATED);
    }

    @PostMapping("/notification")
    @Operation(summary = "Send notification with password reset link", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> sendNotification(@RequestParam("email") String e) {
        UserEntity userByEmail = this.userService.findUserByEmail(e);
        if (userByEmail == null) {
            throw new NotFoundException("User not found");
        } else {
            this.notificationService.sendNotification(userByEmail);
        }
        return new ResponseEntity<>(userByEmail, HttpStatus.OK);
    }
*/



     @PostMapping("/user/signup")
     public  ResponseEntity<?> createUser(@RequestBody UserDto userDto)
     {

         UserEntity userEntity =UserDto.toEntity(userDto);

          List<UserRoleEntity> userRoleEntityList = new ArrayList<>();

          UserRoleEntity userRoleEntity =  userRoleRepository.findByRole(UserRoleEnum.USER).get();
         UserRoleEntity userRoleEntity2 =  userRoleRepository.findByRole(UserRoleEnum.TECHNICIEN).get();


         userRoleEntityList.add(userRoleEntity);
         userRoleEntityList.add(userRoleEntity2);
           userEntity.setRoles(userRoleEntityList);
         userEntity.setTechnicien(userDto.getEmail());

          userEntity.setPassword(passwordEncoder.encode(userDto.getPassword()));



         userRepository.save(userEntity);

         return  ResponseEntity.ok().body(userEntity);



     }

    @PutMapping("/password")
    @Operation(summary = "Update password, (use existing user id)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> setUpNewPassword(@RequestParam Long id, String password) {
        UserEntity userById = this.userService.findUserById(id);
        userById.setPassword(this.passwordEncoder.encode(password));
        this.userService.saveUserWithUpdatedPassword(userById);
        return new ResponseEntity<UserEntity>(userById, HttpStatus.CREATED);
    }

/*    @PutMapping("/business")
    @Operation(summary = "Update business-user, (use existing user id)", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<?> updateBusiness(@RequestBody UpdateBusinessDto business) {
        BusinessOwner businessOwner = this.userService.findBusinessOwnerById(business.getId());
        if (this.userService.businessExists(business.getBusinessName()) && (!businessOwner.getBusinessName().equals(business.getBusinessName()))) {
            throw new RuntimeException("Business name already in use.");
        }
        businessOwner.setBusinessName(business.getBusinessName());
        businessOwner.setPassword(this.passwordEncoder.encode(business.getPassword()));
        businessOwner.setAddress(business.getAddress());
        this.userService.saveUpdatedUser(businessOwner);

        return new ResponseEntity<BusinessOwner>(businessOwner, HttpStatus.CREATED);
    }*/

    @DeleteMapping("/user/{id}")
    @Operation(summary = "Delete user", security = @SecurityRequirement(name = "bearerAuth"))
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {
        boolean isRemoved = this.userService.deleteUser(id);
        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    @Operation(summary = "Authenticate user and get JWT Token")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails
                = hobbieUserDetailsService.loadUserByUsername(jwtRequest.getUsername());

        final String token =
                jwtUtility.generateToken(userDetails);
        return new JwtResponse(token);
    }

    @PostMapping("/login")
    @CrossOrigin(origins = "*")
    @Operation(summary = "Login based on user role after authentication", security = @SecurityRequirement(name = "bearerAuth"))
    public String logInUser(@RequestParam String username) {
        UserEntity userByUsername = this.userService.findUserByUsername(username);
        if (userByUsername.getRoles().stream()
                .anyMatch(u -> u.getRole().equals(UserRoleEnum.USER))) {
            return "USER";
        } else if (userByUsername.getRoles().stream()
                .anyMatch(u -> u.getRole().equals(UserRoleEnum.BUSINESS_USER))) {
            return "BUSINESS_USER";
        }
        return null;
    }
}


