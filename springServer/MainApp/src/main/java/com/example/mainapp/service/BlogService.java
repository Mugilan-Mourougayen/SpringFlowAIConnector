package com.example.mainapp.service;

import com.example.mainapp.Dto.PblogDto;
import com.example.mainapp.Dto.PersonalBlogDto;
import com.example.mainapp.modal.Blogs;
import com.example.mainapp.repository.BlogsRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<PblogDto> getallpublished( ){
        List<PblogDto> blogs =blogsRepository.findAllpublished();
        return blogs;
    }

    public String getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            return username;
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

    public List<PersonalBlogDto> getallblogbyuser(String userName) {
        List<PersonalBlogDto> blogs =blogsRepository.findBlogsByUserName(userName);
        return blogs;

    }

    public String deleteblog(UUID uuid) {


        Optional<Blogs> existing = blogsRepository.findById(uuid);
        if (existing.isPresent()) {
            blogsRepository.deleteById(uuid);
            return "Deleted Sucessfully";
        }
        return "Blog does not exist";
    }
}
