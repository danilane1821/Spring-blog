package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.Posts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {
ArrayList<Posts> postsList;

    public PostController () {
       this.postsList = new ArrayList<Posts>();
        postsList.add(new Posts(1,"first","skjdsdkh"));
        postsList.add(new Posts(2,"second","jndjsnu"));

    }


    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("posts",postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showById(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("posts",postsList.get((int)id -1));

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
}
