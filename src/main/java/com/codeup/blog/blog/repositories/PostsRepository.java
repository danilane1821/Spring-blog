package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post, Long> {
}
