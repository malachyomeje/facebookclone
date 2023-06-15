package com.Stars.Stars.controller;


import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Post;
import com.Stars.Stars.repository.PostRepository;
import com.Stars.Stars.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;



    @PostMapping("/addPost")
    public String addPost(@RequestParam String post) {
        return postService.posting(post);

    }

    @GetMapping
    public UserResponse getPost(@RequestParam Long postId) {
        return postService.getPost(postId);

    }
}