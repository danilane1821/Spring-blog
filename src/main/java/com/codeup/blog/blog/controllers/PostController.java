package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.Models.EmailService;
import com.codeup.blog.blog.Models.Post;

import com.codeup.blog.blog.Models.User;
import com.codeup.blog.blog.repositories.PostsRepository;
import com.codeup.blog.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostsRepository postDao;

    public final UserRepository userDao;

    @Autowired
    EmailService emailService;


    public PostController(PostsRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/posts")
    public String postIndex(Model viewModel){
        viewModel.addAttribute("post", postDao.findAll());
        return "posts/post";
    }

    @GetMapping("/posts/{id}")
    public String showById(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("post", postDao.getOne(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String create(@ModelAttribute Post post){
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUser(currentUser);
        postDao.save(post);
        emailService.prepareAndSend(post, "Ad created", "An Ad has been created, with the id of " + post.getId());
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

        @PostMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute Post post){
            User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            post.setUser(currentUser);
            postDao.save(post);
        return "redirect:/posts/" + id;
    }


    @PostMapping("/posts/{id}/delete")
    public String delete(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }





}
