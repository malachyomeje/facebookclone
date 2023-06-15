package com.Stars.Stars.service;

import com.Stars.Stars.dtos.request.CommentLikeDto;
import com.Stars.Stars.dtos.request.PostLikeDto;
import com.Stars.Stars.dtos.response.UserResponse;

public interface LikeService {

   // UserResponse  addLikes(String likes);


    UserResponse addPostLikes(PostLikeDto postLikeDto);

  //  UserResponse  addCommentLikes(CommentLikeDto commentLikeDto);

  //  UserResponse  addCommentLikes(Long commentId);

    UserResponse  addCommentLikes(CommentLikeDto commentId);
}
