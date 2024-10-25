package com.example.mainapp.repository;

import com.example.mainapp.modal.Blogs;
import com.example.mainapp.modal.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlogsRepository extends JpaRepository<Blogs, UUID> {

}
