package com.example.mainapp.controller;

import com.example.mainapp.modal.Users;
import com.example.mainapp.service.UserDetailService;
import com.example.mainapp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Userlogin {

    private final UserDetailService userDetailService;
    private final UserService userService;

    public Userlogin(UserDetailService userDetailService, UserService userService) {
        this.userDetailService = userDetailService;
        this.userService = userService;
    }


    @GetMapping("/check")
    public String check (){

        return "login assess" ;
    }

    @PostMapping ("/register")
    public ResponseEntity<?> registerUser (@RequestBody Users user){
       var responce =  userDetailService.register(user);
        return responce ;
    }

    @PostMapping ("/login")
    public String login (@RequestBody Map<String, Object> payload  ){
        String email = (String) payload.get("email");
        String password = (String) payload.get("password");
        return userService.verify(email,password);

    }

    @GetMapping("/check2")
    public String finalcont(){
        return "okalaozhi";

    }
}
