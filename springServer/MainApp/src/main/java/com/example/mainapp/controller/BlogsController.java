package com.example.mainapp.controller;

import com.example.mainapp.Dto.PblogDto;
import com.example.mainapp.Dto.PersonalBlogDto;
import com.example.mainapp.modal.Blogs;
import com.example.mainapp.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BlogsController {

    private final BlogService blogService;

    public BlogsController(BlogService blogService) {
        this.blogService = blogService;
    }


    @PostMapping("/create")
    public Blogs creteblog(@RequestBody Blogs blogs){
        System.out.println(blogs);
        blogs.setUserName(blogService.getUserDetails());
        Blogs created = blogService.CreateBlog(blogs);
        return created;
    }

    @PatchMapping("/update")
    public Blogs updateblog(@RequestBody Blogs blogs ){
        Blogs updated = blogService.UpdatedBlog(blogs);
        return updated;
    }

    @GetMapping("/get/")
    public Blogs updateblog(@RequestParam("blogid") UUID uuid){
        Blogs blog = blogService.getBlogbyID(uuid);
        return blog;
    }

    @GetMapping("/checkblog")
    public String check (){
        return "login assess checkblog" ;
    }

    @GetMapping("/getallpublished")
    public List<PblogDto> getallpublished(){
        List<PblogDto> blogs = blogService.getallpublished();
        return blogs;
    }

    @GetMapping("/getallbyuser")
    public List<PersonalBlogDto> getallbyuser(){
        String userName = blogService.getUserDetails();
        List<PersonalBlogDto> blogs = blogService.getallblogbyuser(userName);
        return blogs;
    }

    @DeleteMapping("/delete/")
    public String deleteblog(@RequestParam("blogid") UUID uuid){
      String result = blogService.deleteblog(uuid);
      return result;

    }


}
