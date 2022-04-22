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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    private final long userId = 1000L;

    @Mock(lenient = true)
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @DisplayName("Test Find All Users")
    @Test
    void findAll() {
        User user = new User();
        List<User> users = new LinkedList<>();
        users.add(user);
        given(userRepository.findAll()).willReturn(users);

        List<User> foundUsers = userService.findAll();

        then(userRepository).should().findAll();
        assertThat(foundUsers).isNotNull();
    }

    @DisplayName("Test Get a User By ID")
    @Test
    void get() {
        User user = new User();
        given(userRepository.findById(userId)).willReturn(Optional.of(user));
        User foundUser = userService.get(userId);

        then(userRepository).should().findById(userId);
        assertThat(foundUser).isNotNull();
    }

    @DisplayName("Test Get a User by Username")
    @Test
    void getUserByUsername() {
        userService.getUserByUsername("tester");
        then(userRepository).should().findUserByUsername("tester");
    }

    @DisplayName("Test Delete a User By ID")
    @Test
    void delete() {
        userService.delete(userId);

        then(userRepository).should(times(1)).deleteById(userId);
//        verify(userRepository, atLeastOnce()).deleteById(1000L);
//        verify(userRepository, atMost(5)).deleteById(1000L);
        then(userRepository).should(never()).deleteById(5000L);
    }

    @DisplayName("Test Throw")
    @Test
    void testDoThrow() {
        doThrow(new RuntimeException("crash")).when(userRepository).delete(any());

        assertThrows(RuntimeException.class, () -> userRepository.delete(any()));

        verify(userRepository).delete(any());
    }

    @DisplayName("Test Throw BDD")
    @Test
    void testFindByIdThrow() {
        given(userRepository.findById(userId)).willThrow(new RuntimeException("crash"));

        assertThrows(RuntimeException.class, () -> userService.get(userId));

        then(userRepository).should().findById(userId);
    }

    @Test
    void testDeleteBDD() {
        willThrow(new RuntimeException("crash")).given(userRepository).delete(any());

        assertThrows(RuntimeException.class, () -> userRepository.delete(new User()));

        then(userRepository).should().delete(any());
    }
}