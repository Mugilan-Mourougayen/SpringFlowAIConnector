package com.example.mainapp.config;

import com.example.mainapp.service.JwtService;
import com.example.mainapp.service.UserDetailService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailService userDetailService;

    public JwtFilter(JwtService jwtService, UserDetailService userDetailService) {
        this.jwtService = jwtService;

        this.userDetailService = userDetailService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       String authheader = request.getHeader("Authorization");
       String token = null;
       String email = null;

       if(authheader != null && authheader.startsWith("Bearer ")){
           token = authheader.substring(7);
           email = jwtService.extractEmail(token);

       }
       if(email != null && SecurityContextHolder.getContext().getAuthentication() ==null){
           UserDetails userDetails = userDetailService.loadUserByUsername(email);
           if(jwtService.validateToken(token,userDetails)){
               UsernamePasswordAuthenticationToken token1  = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
               token1.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
               SecurityContextHolder.getContext().setAuthentication(token1);

           }
       }

       filterChain.doFilter(request,response);
    }
}
