package com.also.springApp.repository;

import com.also.springApp.domain.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {

    @Override
    Optional<Reservations> findById(Long id);
}
