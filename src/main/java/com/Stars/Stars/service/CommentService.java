package com.Stars.Stars.service;

import com.Stars.Stars.dtos.request.CommentDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Comment;
import com.Stars.Stars.model.Users;

public interface CommentService {

    UserResponse addComment(CommentDto commentDto);


}
