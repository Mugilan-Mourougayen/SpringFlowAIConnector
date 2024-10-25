package com.example.mainapp.service;

import com.example.mainapp.modal.Blogs;
import jakarta.persistence.Column;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class Mapper {


        public void blogMapper(Blogs fromRequest, Blogs existingBlog) {
            existingBlog.setUuid(fromRequest.getUuid());
            existingBlog.setTitle(fromRequest.getTitle());
            existingBlog.setDescription(fromRequest.getDescription());
            existingBlog.setUserName(fromRequest.getUserName());
            existingBlog.setContent(fromRequest.getContent());
            existingBlog.setLastUpdateAt(fromRequest.getLastUpdateAt());
            existingBlog.setPublishedAt(fromRequest.getPublishedAt());
            existingBlog.setPublished(fromRequest.getPublished());
        }



}
