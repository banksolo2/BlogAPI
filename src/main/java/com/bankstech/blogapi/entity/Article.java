package com.bankstech.blogapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "articles")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Article {
    private static final String DEFAULT_VIEW_COUNT_DEF = "integer default 0" ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;
    private String title;
    private String content;
    private String author;
    private String tag;
    @CreationTimestamp
    private Instant publicationDate;
    @UpdateTimestamp
    private Instant updatedAt;
    @Column(columnDefinition = DEFAULT_VIEW_COUNT_DEF)
    private Integer viewCount = 0;
}
