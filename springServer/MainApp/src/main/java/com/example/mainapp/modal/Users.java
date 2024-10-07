package com.example.mainapp.modal;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class Users  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id ;

    private String username;

    private String password;

    private String email;

    public Users( String username, String password, String email) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Users() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "userauth",joinColumns = @JoinColumn(name="userid"), inverseJoinColumns = @JoinColumn(name="authid"))
//    private Set<Authorities> authorities;


}
