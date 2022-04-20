package com.sirlopu.dojo_reservation_system.service;

import com.sirlopu.dojo_reservation_system.model.Reservation;
import com.sirlopu.dojo_reservation_system.repos.ReservationRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    private final long reservationId = 1000L;

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    ReservationService reservationService;

    @DisplayName("Test Find All Reservations")
    @Test
    void findAll() {
        // given
        Reservation reservation = new Reservation();
        List<Reservation> reservations = new LinkedList<>();
        reservations.add(reservation);
        given(reservationRepository.findAll()).willReturn(reservations);

        // when
        List<Reservation> foundReservations = reservationService.findAll();

        // then
        then(reservationRepository).should().findAll();
        assertThat(foundReservations).isNotNull();
    }

    @DisplayName("Test Get a Reservation By ID")
    @Test
    void get() {
        // given
        Reservation reservation = new Reservation();
        given(reservationRepository.findById(reservationId)).willReturn(Optional.of(reservation));

        // when
        Reservation foundReservation = reservationService.get(reservationId);

        // then
        assertThat(foundReservation).isNotNull();
        then(reservationRepository).should(times(1)).findById(anyLong());  // default is 1
        then(reservationRepository).shouldHaveNoMoreInteractions();
    }

    @DisplayName("Test Delete a Reservation By ID")
    @Test
    void delete() {
        reservationService.delete(reservationId);

        then(reservationRepository).should().deleteById(reservationId);
    }
}