package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/articles")

public class ArticleController{
  
   private final ArticleService articleService;

   public ArticleController(ArticleService ac){
      this.articleService = ac ; 
   }
   
   @GetMapping
   public List<Article> getAllArticle(){
     return articleService.getAllArticle();

   }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id){
     return articleService.getArticleById(id);
    }

    @PostMapping
    public Article createArtile(@RequestBody Article article) {
        return articleService.CreateArticle(article);
    }





}