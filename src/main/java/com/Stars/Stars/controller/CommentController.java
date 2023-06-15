package com.Stars.Stars.controller;

import com.Stars.Stars.dtos.request.CommentDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Comment;
import com.Stars.Stars.model.Users;
import com.Stars.Stars.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
   private final CommentService commentService;

    @PostMapping("/addComment")
    public UserResponse addComment(@RequestBody CommentDto commentDto){
       return commentService.addComment(commentDto);


    }



}
