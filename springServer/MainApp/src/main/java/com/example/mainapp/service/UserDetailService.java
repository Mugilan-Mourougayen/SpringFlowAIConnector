package com.example.mainapp.service;

import com.example.mainapp.Security.UsersDetail;
import com.example.mainapp.modal.Users;
import com.example.mainapp.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public UserDetailService(UserRepository userRepository, JwtService jwtService ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            var userOptional = userRepository.findByEmail(email);

            if (userOptional.isPresent()) {

                return new UsersDetail(userOptional.get());
            } else {

                throw new UsernameNotFoundException("User with username " + email + " not found.");
            }
        } catch (Exception e) {

            throw new InternalAuthenticationServiceException("Error occurred while loading user by username: " + email, e);
        }
    }
    public ResponseEntity<?> register(Users user) {

        Optional<Users> userOptional = userRepository.findByEmail(user.getEmail());

        if (userOptional.isPresent()) {
            return ResponseEntity.status(405).body("user already exist");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            Users usr =userRepository.save(user);
            return ResponseEntity.status(200).body(usr);
        }


    }



}
