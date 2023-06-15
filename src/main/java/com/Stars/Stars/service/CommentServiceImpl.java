package com.Stars.Stars.service;

import com.Stars.Stars.dtos.request.CommentDto;
import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Comment;
import com.Stars.Stars.model.Likes;
import com.Stars.Stars.model.Post;
import com.Stars.Stars.model.Users;
import com.Stars.Stars.repository.CommentRepository;
import com.Stars.Stars.repository.LikeRepository;
import com.Stars.Stars.repository.PostRepository;
import com.Stars.Stars.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor

public class CommentServiceImpl implements CommentService{

    private final UsersRepository usersRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;




    @Override
    public UserResponse addComment(CommentDto commentDto){
        String email=SecurityContextHolder.getContext().getAuthentication().getName();
    Optional<Users> users = usersRepository.findByEmail(email);
    if (users.isEmpty()){
        return new UserResponse<>("user not found",users);
    }
    Optional<Post> post = postRepository.findById(commentDto.getPostId());
    if (post.isEmpty()){
        return new UserResponse<>("post not found",post);
    }



   Comment comment = new Comment();
   comment.setPost(post.get());
   comment.setComment(commentDto.getComment());



   commentRepository.save(comment);

    return new UserResponse<>("Commented success",comment);
    }



}
