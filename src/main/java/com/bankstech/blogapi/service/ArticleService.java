package com.bankstech.blogapi.service;

import com.bankstech.blogapi.entity.Article;
import com.bankstech.blogapi.model.ResponseMessage;

import java.util.List;

public interface ArticleService {

    public ResponseMessage filterArticles(String search);

    public ResponseMessage createArticle(Article article);

    public ResponseMessage getArticleById(Long id);

    public ResponseMessage updateArticle(Long id, Article article);

    public ResponseMessage deleteArticle(Long id);

}
