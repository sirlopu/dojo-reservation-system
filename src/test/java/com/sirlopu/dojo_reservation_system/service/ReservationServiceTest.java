package com.sirlopu.dojo_reservation_system.service;

import com.sirlopu.dojo_reservation_system.model.Reservation;
import com.sirlopu.dojo_reservation_system.repos.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    ReservationService reservationService;

    @Test
    void findAll() {
    }

    @Test
    void get() {
        Reservation reservation = new Reservation();

        when(reservationRepository.findById(1000L)).thenReturn(Optional.of(reservation));

        Reservation foundReservation = reservationService.get(1000L);

        assertThat(foundReservation).isNotNull();

        verify(reservationRepository).findById(1000L);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        reservationService.delete(1000L);

        verify(reservationRepository).deleteById(1000L);
    }
}