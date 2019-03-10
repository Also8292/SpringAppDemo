package com.also.springApp.web.rest;

import com.also.springApp.domain.Reservations;
import com.also.springApp.repository.ReservationsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ReservationsRessource {

    private final Logger log = LoggerFactory.getLogger(ReservationsRessource.class);

    private static final String ENTITY_NAME = "reservations";

    private final ReservationsRepository reservationsRepository;

    public ReservationsRessource(ReservationsRepository reservationsRepository) {
        this.reservationsRepository = reservationsRepository;
    }

    /**
     *
     * */
    @PostMapping("/reservations")
    public ResponseEntity<Reservations> createReservation(@RequestBody Reservations reservations) throws URISyntaxException {
        log.debug("REST request to save reservations : ()", reservations);
        if(reservations.getId() != null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for create");
        }
        Reservations result = reservationsRepository.save(reservations);
        return ResponseEntity.created(new URI("/api/reservations/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @PutMapping("/reservations")
    public ResponseEntity<Reservations> updateReservation(@RequestBody Reservations reservations) throws URISyntaxException {
        log.debug("REST request to update reservations : ()", reservations);
        if(reservations.getId() == null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for update");
        }
        Reservations result = reservationsRepository.save(reservations);
        return ResponseEntity.created(new URI("/api/reservations/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @GetMapping("/reservations")
    public List<Reservations> getAllReservations() {
        log.debug("REST request to get all reservations");
        return reservationsRepository.findAll();
    }

    /**
     *
     */
    @GetMapping("/reservations/{id}")
    public Optional<Reservations> getReservationById(@PathVariable Long id) {
        log.debug(("REST request to get one reservation by id"));
        return reservationsRepository.findById(id);
    }
}
