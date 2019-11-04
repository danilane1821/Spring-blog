package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String index(){
        return "post index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String showById(@PathVariable long id){
        return "view an individual post";
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
        return "create a new post";
    }
}
