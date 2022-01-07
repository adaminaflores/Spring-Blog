package com.codeup.springblog.controllers;

import com.codeup.springblog.interfaces.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String indexPage(Model model){
       model.addAttribute("posts", postDao.findAll());
       return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable int id){
        return "posts/show";
    }

    @GetMapping("/posts/edit/{id}")
    public String editPost(@PathVariable long id, Model model){
        Post editPost = postDao.getById(id);

        model.addAttribute("postToEdit", editPost);
        return "posts/edit";
    }
    @PostMapping("/posts/edit")
    public String saveEditPost(@RequestParam(name="postTitle") String postTitle, @RequestParam(name="postBody") String postBody, @RequestParam(name="postId") long id){

        Post postToEdit = postDao.getById(id);

        postToEdit.setBody(postBody);
        postToEdit.setTitle(postTitle);
        ;

        postDao.save(postToEdit);

        return "redirect:/posts";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable long id){
        long deletePostId = id;
        postDao.deleteById(deletePostId);

        return "redirect:/posts";
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
