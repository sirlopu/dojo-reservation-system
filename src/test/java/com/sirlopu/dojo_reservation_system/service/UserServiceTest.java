package com.sirlopu.dojo_reservation_system.service;

import com.sirlopu.dojo_reservation_system.model.User;
import com.sirlopu.dojo_reservation_system.repos.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void delete() {
        userService.delete(1000L);

        verify(userRepository, times(1)).deleteById(1000L);
//        verify(userRepository, atLeastOnce()).deleteById(1000L);
//        verify(userRepository, atMost(5)).deleteById(1000L);
        verify(userRepository, never()).deleteById(5000L);
    }

    @Test
    void findAll() {
    }

    @Test
    void get() {
        User user = new User();

        when(userRepository.findById(1000L)).thenReturn(Optional.of(user));

        User foundUser = userService.get(1000L);

        assertThat(foundUser).isNotNull();

        verify(userRepository).findById(1000L);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void getUserByUsername() {
        userService.getUserByUsername("tester");
        verify(userRepository).findUserByUsername("tester");
    }


}