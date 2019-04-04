package com.also.springApp.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.also.springApp.model.Users;
import com.also.springApp.repository.UsersRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class UsersController {
	
	private final Logger log = LoggerFactory.getLogger(UsersController.class);
	private final UsersRepository usersRopository;
	
	public UsersController(UsersRepository usersRepository) {
		this.usersRopository = usersRepository;
	}
	
	@PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users users) throws URISyntaxException {
        log.debug("REST request to save User : ()", users);
        if(users.getId() != null) {
            //throw new HttpClientErrorException.BadRequest();
            System.out.println("Bad request for create");
        }
        
        System.out.println("USER BEFORE : " + users);
        
        users.setPassword(users.getPassword());
        
        System.out.println("USER AFTER : " + users);
        
        Users result = usersRopository.save(users);
        return ResponseEntity.created(new URI("/api/users/" + result.getId().toString())).body(result);
    }
	
	
	@GetMapping("/users")
	public List<Users> getAllUsers() {
        return usersRopository.findAll();
    }
	
	
	
	
	
	
	
	
	
}
