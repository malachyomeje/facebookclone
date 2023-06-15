package com.Stars.Stars.repository;

import com.Stars.Stars.model.Comment;
import com.Stars.Stars.model.Likes;
import com.Stars.Stars.model.Post;
import com.Stars.Stars.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Likes,Long> {

    Optional<Likes> findByUsersAndPost(Users users,Post Post);
    List<Likes> findAllByPost(Post post);
    List<Likes>findAllByComment(Comment comment);

    Optional<Likes> findByUsersAndComment(Users users, Comment comment);
}
