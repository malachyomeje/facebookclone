package com.Stars.Stars.controller;

import com.Stars.Stars.dtos.request.CommentLikeDto;
import com.Stars.Stars.dtos.request.PostLikeDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/comment")
@RequiredArgsConstructor
public class likesController {
   private final LikeService likeService;

    @PostMapping("/addPostLike")
    public UserResponse addPostLike(@RequestBody PostLikeDto postLikeDto){
       return likeService.addPostLikes(postLikeDto);


    }

    @PostMapping("/addCommentLike")
    public UserResponse addCommentLike(@RequestBody CommentLikeDto commentId){
        return likeService.addCommentLikes(commentId);


    }


}
