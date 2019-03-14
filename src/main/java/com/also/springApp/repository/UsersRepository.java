package com.also.springApp.repository;

import com.also.springApp.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long aLong);

    Optional<Users> findUsersByEmail(String email);

}
