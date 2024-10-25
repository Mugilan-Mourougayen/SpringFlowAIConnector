package com.example.mainapp.repository;

import com.example.mainapp.Dto.PblogDto;
import com.example.mainapp.Dto.PersonalBlogDto;
import com.example.mainapp.modal.Blogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface BlogsRepository extends JpaRepository<Blogs, UUID> {
    @Query("SELECT new com.example.mainapp.Dto.PblogDto(a.uuid, a.title, a.description, a.userName, a.publishedAt, a.published) " +
            "FROM Blogs a WHERE a.published = true")
    List<PblogDto> findAllpublished();


    @Query("SELECT new com.example.mainapp.Dto.PersonalBlogDto(a.uuid, a.title, a.description, a.lastUpdateAt, a.publishedAt, a.published) " +
            "FROM Blogs a WHERE a.userName = :name")
    List<PersonalBlogDto> findBlogsByUserName(@Param("name") String name);

}

