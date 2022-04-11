package com.sirlopu.dojo_reservation_system;

import com.sirlopu.dojo_reservation_system.model.AmenityType;
import com.sirlopu.dojo_reservation_system.model.Capacity;
import com.sirlopu.dojo_reservation_system.model.User;
import com.sirlopu.dojo_reservation_system.repos.CapacityRepository;
import com.sirlopu.dojo_reservation_system.repos.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class DojoReservationSystemApplication {

    // TEST ONLY - REMOVE FOR PROD
    // TODO: IMPLEMENT CAPACITY SERVICE
    private Map<AmenityType, Integer> initialCapacities =
            new HashMap<>() {
                {
                    put(AmenityType.CODING, 18);
                    put(AmenityType.GAME_NIGHT, 20);
                    put(AmenityType.BIRTHDAY_PARTY, 30);
                }
            };
    /////////////////////////////////

    public static void main(String[] args) {
        SpringApplication.run(DojoReservationSystemApplication.class, args);
    }

    // TEST ONLY - REMOVE FOR PROD
    @Bean
    public CommandLineRunner loadData(
            UserRepository userRepository,
            CapacityRepository capacityRepository) {
        return (args) -> {
            userRepository.save(
                    new User("Tester 1", "tester1", bCryptPasswordEncoder().encode("12345")));
            for (AmenityType amenityType : initialCapacities.keySet()) {
                capacityRepository.save(new Capacity(amenityType, initialCapacities.get(amenityType)));
            }
        };
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    /////////////////////////////////
}
