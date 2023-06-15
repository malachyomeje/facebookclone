package com.Stars.Stars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.security.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Post {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 private Long id;

 private String post;

 @CreationTimestamp
 private Date date;

@ManyToOne
@JoinColumn(name = "user_id",referencedColumnName = "id")
//@JsonIgnore
 private  Users users;

 @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
 private List<Comment> comments;


 @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
 private List<Likes> likes;


}
