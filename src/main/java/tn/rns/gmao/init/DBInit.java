package tn.rns.gmao.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tn.rns.gmao.services.UserService;

//@Component
public class DBInit implements CommandLineRunner {
    private final UserService userService;


    @Autowired
    public DBInit(UserService userService) {
        this.userService = userService;

    }

    @Override
    public void run(String... args) throws Exception {
        this.userService.seedUsersAndUserRoles();

    }

}
