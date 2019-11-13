package com.codeup.blog.blog.controllers;

//import org.springframework.security.core.context.SecurityContextHolder;
import com.codeup.blog.blog.Models.User;
import com.codeup.blog.blog.repositories.PostsRepository;
import com.codeup.blog.blog.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

//    private final PostsRepository postDao;
//    public final UserRepository userDao;
//
//    public HomeController(PostsRepository postDao, UserRepository userDao) {
//        this.postDao = postDao;
//        this.userDao = userDao;
//    }

    @GetMapping("/")
    public String index(Model viewModel){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "posts/index";
    }


}
