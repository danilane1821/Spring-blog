package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.Posts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

//    @GetMapping("/")
//    public String index(Model viewModel) {
//        ArrayList<Posts> postList = new ArrayList<Posts>();
//        postList.add(new Posts(2,"second Post","skjdsdkh"));
//        postList.add(new Posts(3,"third Post","jndjsnu"));
//
//        viewModel.addAttribute("posts", postList);
//        return "index";
//    }
//
//
//
//    @GetMapping("/show/{id}")
//
//    public String showById(@PathVariable (name = "id") long id, Model viewModel){
//        Posts post = new Posts(1,"new","fjdkfjk");
//        viewModel.addAttribute("post",post);
//
//        return "show";
//    }
//
//    @GetMapping("/posts/create")
//    @ResponseBody
//    public String showForm(){
//        return "view the form for creating a post";
//    }
//
//    @PostMapping("/posts/create")
//    @ResponseBody
//    public String create(@RequestParam String title,@RequestParam String body){
//        System.out.println("title = " + title);
//        System.out.println("body = " + body);
//        return "show";
//    }
}
