package com.example.mainapp.service;

import com.example.mainapp.modal.Blogs;
import com.example.mainapp.repository.BlogsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BlogService {
    private final BlogsRepository blogsRepository;
    private final Mapper mapper;

    public BlogService(BlogsRepository blogsRepository, Mapper mapper) {
        this.blogsRepository = blogsRepository;
        this.mapper = mapper;
    }

    public Blogs CreateBlog(Blogs blogs){
        Blogs blog =blogsRepository.save(blogs);
        return blog;
    }

    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return "Current username: " + username;
        }
        return "Anonymous User";
    }

    public Blogs UpdatedBlog(Blogs blogs) {
        Optional<Blogs> existing = blogsRepository.findById(blogs.getUuid());
        if (existing.isPresent()) {
            Blogs existingBlog = existing.get();
            mapper.blogMapper(blogs,existingBlog);
            return blogsRepository.save(existingBlog);
        }

        return blogs;
    }

    public Blogs getBlogbyID(UUID uuid) {
        Optional<Blogs> existing = blogsRepository.findById(uuid);
        Blogs existingBlog = existing.get();
        return existingBlog;
    }
}
