package com.Stars.Stars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Getter@Setter
//@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String comment;
    @CreationTimestamp
    private  Date date;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "postId",referencedColumnName = "id"
    )
  private  Post post;

    @OneToMany(mappedBy = "comment",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Likes> likes;

}



