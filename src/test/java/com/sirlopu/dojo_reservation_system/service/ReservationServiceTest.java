package com.sirlopu.dojo_reservation_system.service;

import com.sirlopu.dojo_reservation_system.model.Reservation;
import com.sirlopu.dojo_reservation_system.repos.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    private final long reservationId = 1000L;

    @Mock
    ReservationRepository reservationRepository;

    @InjectMocks
    ReservationService reservationService;

    @Test
    void findAll() {
        Reservation reservation = new Reservation();

        List<Reservation> reservations = new LinkedList<>();

        reservations.add(reservation);

        when(reservationRepository.findAll()).thenReturn(reservations);

        List<Reservation> foundReservations = reservationService.findAll();

        verify(reservationRepository).findAll();
        assertThat(foundReservations).isNotNull();
    }

    @Test
    void get() {
        Reservation reservation = new Reservation();

        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(reservation));

        Reservation foundReservation = reservationService.get(reservationId);

        assertThat(foundReservation).isNotNull();

        verify(reservationRepository).findById(reservationId);
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        reservationService.delete(reservationId);

        verify(reservationRepository).deleteById(reservationId);
    }
}