package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.Posts;

import com.codeup.blog.blog.repositories.PostsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostsRepository postDao;

    public PostController(PostsRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showById(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("posts", postDao.getOne(id));

        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String showForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String create(@RequestParam String title,@RequestParam String body){
        System.out.println("title = " + title);
        System.out.println("body = " + body);
        return "create a new form";
    }

    @GetMapping("/posts/edit")
    public String editForm(){
        return "posts/edit";
    }

    @PostMapping("/posts/edit")
    public String edit(@RequestParam String title,@RequestParam String body,Model viewModel){
        viewModel.addAttribute("postsTitle", title);
        viewModel.addAttribute("postsBody", body);
        return "posts/edit";
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam(name = "id") long id, Model viewModel){
        postDao.deleteById(id);
        viewModel.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }





}
