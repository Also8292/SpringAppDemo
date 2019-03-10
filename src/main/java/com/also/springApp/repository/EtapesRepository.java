package com.also.springApp.repository;

import com.also.springApp.domain.Etapes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@SuppressWarnings("unused")
@Repository
public interface EtapesRepository extends JpaRepository<Etapes, Long> {

    @Override
    Optional<Etapes> findById(Long id);
}
