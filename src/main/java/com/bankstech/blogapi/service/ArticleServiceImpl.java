package com.bankstech.blogapi.service;

import com.bankstech.blogapi.entity.Article;
import com.bankstech.blogapi.model.ResponseMessage;
import com.bankstech.blogapi.repository.ArticleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @Override
    public ResponseMessage filterArticles(String search) {
        List<Article> articles = articleRepository.filterArticles(search);
        if(articles.isEmpty()){
            return ResponseMessage.builder()
                    .type("error")
                    .message("No articles found matching the search criteria")
                    .data(null)
                    .httpStatus(HttpStatus.NOT_FOUND)
                    .build();
        }
        return ResponseMessage.builder()
                .type("success")
                .message("Articles retrieved successfully")
                .data(articles)
                .httpStatus(HttpStatus.OK)
                .build();

    }

    @Override
    public ResponseMessage createArticle(Article article) {
        try{
            Article savedArticle = articleRepository.save(article);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Article created successfully")
                    .data(savedArticle)
                    .httpStatus(org.springframework.http.HttpStatus.CREATED)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message("Failed to create article: " + ex.getMessage())
                    .data(null)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @Override
    public ResponseMessage getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if(Objects.nonNull(article)){
            return ResponseMessage.builder()
                    .type("success")
                    .message("Article retrieved successfully")
                    .data(article)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        return ResponseMessage.builder()
                .type("error")
                .message("Article not found with id: " + id)
                .data(null)
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
    }

    @Override
    public ResponseMessage updateArticle(Long id, Article article) {
        try{
            Article existingArticle = articleRepository.findById(id).orElse(null);
            if(Objects.isNull(existingArticle)){
                return ResponseMessage.builder()
                        .type("error")
                        .message("Article not found with id: " + id)
                        .data(null)
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build();
            }
            existingArticle.setTitle(article.getTitle());
            existingArticle.setContent(article.getContent());
            existingArticle.setAuthor(article.getAuthor());
            existingArticle.setTag(article.getTag());
            Article updatedArticle = articleRepository.save(existingArticle);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Article updated successfully")
                    .data(updatedArticle)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message("Failed to update article: " + ex.getMessage())
                    .data(null)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @Override
    public ResponseMessage deleteArticle(Long id) {
        try{
            Article existingArticle = articleRepository.findById(id).orElse(null);
            if(Objects.isNull(existingArticle)){
                return ResponseMessage.builder()
                        .type("error")
                        .message("Article not found with id: " + id)
                        .data(null)
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .build();
            }
            articleRepository.deleteById(id);
            return ResponseMessage.builder()
                    .type("success")
                    .message("Article deleted successfully")
                    .data(null)
                    .httpStatus(HttpStatus.OK)
                    .build();
        }
        catch(Exception ex){
            return ResponseMessage.builder()
                    .type("error")
                    .message("Failed to delete article: " + ex.getMessage())
                    .data(null)
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
