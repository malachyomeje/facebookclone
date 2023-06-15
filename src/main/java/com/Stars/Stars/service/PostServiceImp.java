package com.Stars.Stars.service;

import com.Stars.Stars.dtos.response.UserResponse;
import com.Stars.Stars.model.Post;
import com.Stars.Stars.model.Users;
import com.Stars.Stars.repository.LikeRepository;
import com.Stars.Stars.repository.PostRepository;
import com.Stars.Stars.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor


public class PostServiceImp implements PostService{

    private final PostRepository postRepository;
    private final UsersRepository usersRepository;
    @Override
   public String posting(String post) {
    String email = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<Users> users =usersRepository.findByEmail(email);


        if (users.isEmpty()){
            return  "user not found";
        }
    Post post1 = new Post();
        post1.setPost(post);
        post1.setUsers(users.get());


    postRepository.save(post1);

    return "post save";
   }
   @Override
public UserResponse getPost(Long postId){
      Optional<Post> post =postRepository.findById(postId);
      if (post.isEmpty()) {
          return new UserResponse ("no post found",post);
      }
          postRepository.save(post.get());
 return new UserResponse ("success",post);
}
}