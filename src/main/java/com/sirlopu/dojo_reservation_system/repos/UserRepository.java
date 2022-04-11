package com.sirlopu.dojo_reservation_system.repos;

import com.sirlopu.dojo_reservation_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);
}
