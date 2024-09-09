package org.example.exams.data;

import org.example.exams.entity.*;
import org.example.exams.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Set;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, PlaceRepository placeRepository) {
        return args -> {

            Role adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);

            Role publicRole = new Role();
            publicRole.setName("PUBLIC");
            roleRepository.save(publicRole);


            User admin = new User();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setRoles(Set.of(adminRole));
            userRepository.save(admin);


            Place place1 = new Place();
            place1.setName("Hoi An");
            place1.setDescription("A beautiful ancient town.");
            place1.setImage("src/main/java/org/example/exams/images/hoi-an-1680591517857660432696.webp");
            place1.setAverageRating(4.5);
            placeRepository.save(place1);

            Place place2 = new Place();
            place2.setName("Sai Gon");
            place2.setDescription("A vibrant city in Vietnam.");
            place2.setImage("src/main/java/org/example/exams/images/sunset-on-saigon-river.jpg");
            place2.setAverageRating(4.7);
            placeRepository.save(place2);

        };
    }
}