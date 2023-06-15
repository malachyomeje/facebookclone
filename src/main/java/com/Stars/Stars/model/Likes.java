package com.Stars.Stars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

   // private Integer likes;
    @CreationTimestamp
    private  Date date;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "postId",referencedColumnName = "id")
    private  Post post;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "commentId",referencedColumnName = "id")
    private  Comment comment;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private  Users users;


}



