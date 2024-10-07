package com.example.mainapp.repository;

import com.example.mainapp.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("""
       SELECT u FROM Users u WHERE u.username = :username
   """)
    Optional <Users> findByUsername(String username);

    @Query("""
       SELECT u FROM Users u WHERE u.email = :email
   """)
    Optional<Users> findByEmail(String email);
}
