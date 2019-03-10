package com.also.springApp.web.rest;


import com.also.springApp.domain.Trajets;
import com.also.springApp.repository.TrajetsRepository;
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
public class TrajetsRessource {

    private final Logger log = LoggerFactory.getLogger(TrajetsRessource.class);

    private static final String ENTITY_NAME = "trajets";

    private final TrajetsRepository trajetsRepository;

    public TrajetsRessource(TrajetsRepository trajetsRepository) {
        this.trajetsRepository = trajetsRepository;
    }

    /**
     *
     * */
    @PostMapping("/trajets")
    public ResponseEntity<Trajets> createTrajet(@RequestBody Trajets trajets) throws URISyntaxException {
        log.debug("REST request to save Trajet : ()", trajets);
        if(trajets.getId() != null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for create");
        }
        Trajets result = trajetsRepository.save(trajets);
        return ResponseEntity.created(new URI("/api/trajets/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @PutMapping("/trajets")
    public ResponseEntity<Trajets> updateTrajet(@RequestBody Trajets trajets) throws URISyntaxException {
        log.debug("REST request to update trajet : ()", trajets);
        if(trajets.getId() == null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for update");
        }
        Trajets result = trajetsRepository.save(trajets);
        return ResponseEntity.created(new URI("/api/trajets/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @GetMapping("/trajets")
    public List<Trajets> getAllTrajets() {
        log.debug("REST request to get all trajets");
        return trajetsRepository.findAll();
    }

    /**
     *
     */
    @GetMapping("/trajets/{id}")
    public Optional<Trajets> getTrajetById(@PathVariable Long id) {
        log.debug(("REST request to get one trajet by id"));
        return trajetsRepository.findById(id);
    }
}
