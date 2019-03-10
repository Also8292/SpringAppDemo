package com.also.springApp.repository;

import com.also.springApp.domain.Trajets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrajetsRepository extends JpaRepository<Trajets, Long> {

    @Override
    Optional<Trajets> findById(Long id);
}
