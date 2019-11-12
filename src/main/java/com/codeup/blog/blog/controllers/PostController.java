package com.codeup.blog.blog.controllers;
import com.codeup.blog.blog.Post;

import com.codeup.blog.blog.User;
import com.codeup.blog.blog.repositories.PostsRepository;
import com.codeup.blog.blog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostsRepository postDao;

    public final UserRepository userDao;

    public PostController(PostsRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }



    @GetMapping("/posts")
    public String index(Model viewModel){
        viewModel.addAttribute("post", postDao.findAll());
        return "posts/index";
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
        post.setUser(userDao.getOne(1L));
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

//    @PostMapping("/posts/{id}/edit")
//    public String edit(@PathVariable long id,@RequestParam String title,@RequestParam String body){
//        Post oldPost = postDao.getOne(id);
//        oldPost.setTitle(title);
//        oldPost.setBody(body);
//        postDao.save(oldPost);
//        return "redirect:/posts/" + id;
//    }

        @PostMapping("/posts/{id}/edit")
    public String edit(@PathVariable long id, @ModelAttribute Post post){
            post.setUser(userDao.getOne(2l));
            postDao.save(post);

        return "redirect:/posts/" + id;
    }

    @PostMapping("/posts/delete")
    public String delete(@RequestParam(name = "id") long id, Model viewModel){
        postDao.deleteById(id);
        viewModel.addAttribute("post", postDao.findAll());
        return "redirect:/posts";
    }





}
