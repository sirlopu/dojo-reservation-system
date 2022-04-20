package com.sirlopu.dojo_reservation_system.service;

import com.sirlopu.dojo_reservation_system.model.User;
import com.sirlopu.dojo_reservation_system.repos.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final long userId = 1000L;

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @DisplayName("Test Find All Users")
    @Test
    void findAll() {
        User user = new User();

        List<User> users = new LinkedList<>();

        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        List<User> foundUsers = userService.findAll();

        verify(userRepository).findAll();
        assertThat(foundUsers).isNotNull();
    }

    @DisplayName("Test Get a User By ID")
    @Test
    void get() {
        User user = new User();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        User foundUser = userService.get(userId);

        assertThat(foundUser).isNotNull();

        verify(userRepository).findById(userId);
    }

    @Test
    void create() {
    }

    @Test
    void update() {

    }

    @DisplayName("Test Get a User by Username")
    @Test
    void getUserByUsername() {
        userService.getUserByUsername("tester");
        verify(userRepository).findUserByUsername("tester");
    }

    @DisplayName("Test Delete a User By ID")
    @Test
    void delete() {
        userService.delete(userId);

        verify(userRepository, times(1)).deleteById(userId);
//        verify(userRepository, atLeastOnce()).deleteById(1000L);
//        verify(userRepository, atMost(5)).deleteById(1000L);
        verify(userRepository, never()).deleteById(5000L);
    }

}