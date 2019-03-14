package com.also.springApp.web.rest;

import com.also.springApp.domain.Users;
import com.also.springApp.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UsersRessource {

    private final Logger log = LoggerFactory.getLogger(UsersRessource.class);

    private static final String ENTITY_NAME = "users";

    private final UsersRepository usersRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersRessource(UsersRepository usersRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.usersRepository = usersRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    /**
     *
     * */
    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users users) throws URISyntaxException {
        log.debug("REST request to save User : ()", users);
        if(users.getId() != null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for create");
        }
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        Users result = usersRepository.save(users);
        return ResponseEntity.created(new URI("/api/users/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @PutMapping("/users")
    public ResponseEntity<Users> updateUser(@RequestBody Users users) throws URISyntaxException {
        log.debug("REST request to update User : ()", users);
        if(users.getId() == null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for update");
        }
        Users result = usersRepository.save(users);
        return ResponseEntity.created(new URI("/api/users/" + result.getId().toString())).body(result);
    }

    /**
     *
     * */
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        log.debug("REST request to get all users");
        return usersRepository.findAll();
    }

    /**
     *
     */
    @GetMapping("/users/{id}")
    public Optional<Users> getUsersById(@PathVariable Long id) {
        log.debug(("REST request to get one user by id"));
        return usersRepository.findById(id);
    }

    @GetMapping("/users/{email}")
    public Optional<Users> getUsersByEmail(@PathVariable String email) {
        log.debug(("REST request to get one user by email"));
        return usersRepository.findUsersByEmail(email);
    }
}
