package com.Stars.Stars.service;

import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Post;
import com.Stars.Stars.model.Users;

public interface PostService {

    String posting(String post);

    UserResponse getPost(Long postId);
}
