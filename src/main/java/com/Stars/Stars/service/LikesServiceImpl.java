package com.Stars.Stars.service;

import com.Stars.Stars.dtos.request.CommentLikeDto;
import com.Stars.Stars.dtos.request.PostLikeDto;
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
public class LikesServiceImpl implements LikeService {

    private final UsersRepository usersRepository;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;



    @Override

    public UserResponse addPostLikes(PostLikeDto postLikeDto) {


        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Users> users = usersRepository.findByEmail(email);
        if (users.isEmpty()) {
            return new UserResponse<>("User not found", users);
        }
        Optional<Post> post = postRepository.findById(postLikeDto.getPostId());
        if (post.isEmpty()) {
            return new UserResponse<>("post not found", users);
        }

        Optional<Likes> optionalLikes = likeRepository.findByUsersAndPost(users.get(),post.get());

        if(optionalLikes.isPresent()){
            likeRepository.delete(optionalLikes.get());
        }else {
        Likes likes1 = new Likes();
        likes1.setPost(post.get());
        likes1.setUsers(users.get());
        likeRepository.save(likes1);

        }
        int numberOfLikes = likeRepository.findAllByPost(post.get()).size();
        return new UserResponse<>("like success", numberOfLikes);

    }


@Override
    public UserResponse  addCommentLikes( CommentLikeDto commentLikeDto){
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Users> users =usersRepository.findByEmail(email);
        if (users.isEmpty()){
            return new UserResponse<>("User not found",users);
        }

        Optional<Comment> comment= commentRepository.findById(commentLikeDto.getCommentId());
        if (comment.isEmpty()){
            return new UserResponse<>("post not found",users);
        }

    Optional<Likes> optionalComment = likeRepository.findByUsersAndComment(users.get(),comment.get());

        if (optionalComment.isPresent()){
            likeRepository.delete(optionalComment.get());
        }
        else {
            Likes likes1 = new Likes();
            likes1.setComment(comment.get());
            likes1.setUsers(users.get());
            likeRepository.save(likes1);
        }

    int numberOfComment = likeRepository.findAllByComment(comment.get()).size();
        return new UserResponse<>("like success",numberOfComment);

    }




}
