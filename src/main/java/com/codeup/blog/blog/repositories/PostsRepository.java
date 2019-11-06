package com.codeup.blog.blog.repositories;

import com.codeup.blog.blog.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}
