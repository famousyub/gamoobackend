package tn.rns.gmao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GmaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmaoApplication.class, args);
    }

}
