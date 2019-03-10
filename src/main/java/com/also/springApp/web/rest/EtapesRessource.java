package com.also.springApp.web.rest;

import com.also.springApp.domain.Etapes;
import com.also.springApp.repository.EtapesRepository;
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
public class EtapesRessource {
    private final Logger log = LoggerFactory.getLogger(EtapesRessource.class);

    private static final String ENTITY_NAME = "etapes";

    private final EtapesRepository etapesRepository;

    public EtapesRessource(EtapesRepository etapesRepository) {
        this.etapesRepository = etapesRepository;
    }

    /**
     *
     * */
    @PostMapping("/etapes")
    public ResponseEntity<Etapes> createEtape(@RequestBody Etapes etapes) throws URISyntaxException {
        log.debug("REST request to save etape : ()", etapes);
        if(etapes.getId() != null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for create");
        }
        Etapes result = etapesRepository.save(etapes);
        return ResponseEntity.created(new URI("/api/etapes/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @PutMapping("/etapes")
    public ResponseEntity<Etapes> updateEtape(@RequestBody Etapes etapes) throws URISyntaxException {
        log.debug("REST request to update etape : ()", etapes);
        if(etapes.getId() == null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for update");
        }
        Etapes result = etapesRepository.save(etapes);
        return ResponseEntity.created(new URI("/api/etapes/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @GetMapping("/etapes")
    public List<Etapes> getAllEtapes() {
        log.debug("REST request to get all etapes");
        return etapesRepository.findAll();
    }

    /**
     *
     */
    @GetMapping("/etapes/{id}")
    public Optional<Etapes> getEtapesById(@PathVariable Long id) {
        log.debug(("REST request to get one etape by id"));
        return etapesRepository.findById(id);
    }
}
