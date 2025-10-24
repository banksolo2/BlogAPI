package com.bankstech.blogapi.repository;

import com.bankstech.blogapi.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query("SELECT a FROM Article a WHERE " +
            "LOWER(a.title) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.author) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(a.tag) LIKE LOWER(CONCAT('%', :search, '%'))")
    public List<Article> filterArticles(@Param("search") String search);

}
