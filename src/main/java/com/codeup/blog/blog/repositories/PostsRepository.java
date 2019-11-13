package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Post, Long> {
}
