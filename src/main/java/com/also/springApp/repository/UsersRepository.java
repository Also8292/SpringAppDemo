package com.also.springApp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.also.springApp.model.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {
		
}
