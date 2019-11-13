package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.Models.Post;
import com.codeup.blog.blog.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {

}
