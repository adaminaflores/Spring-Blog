package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String indexPage(Model model){
        Post newPost1 = new Post("Post 1", "this is post 1");
        Post newPost2 = new Post("Post 2", "this is post 2");

        ArrayList<Post> posts = new ArrayList<>();

        posts.add(newPost1);
        posts.add(newPost2);

        model.addAttribute("allPosts", posts);

        return "posts/index";
    }

    @GetMapping("/posts/show")
    public String singlePost(Model viewModel){
        Post newPost =  new Post("Hello World", "Welcome to Codeup!");
        viewModel.addAttribute("post", newPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }

}
