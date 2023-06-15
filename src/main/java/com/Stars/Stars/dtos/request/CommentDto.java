package com.Stars.Stars.dtos.request;

import com.Stars.Stars.model.Post;
import lombok.Data;

@Data
public class CommentDto {
    private String comment;
    private Long postId;
    private Long likes;

}
