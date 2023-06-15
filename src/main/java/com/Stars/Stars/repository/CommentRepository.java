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
public interface CommentRepository extends JpaRepository<Comment, Long> {
//    Comment findByEmail(String email);
}
