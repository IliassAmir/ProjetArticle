package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import java.util.Optional;

@Service
@Transactional

public class ArticleService {
    

    private final ArticleRepository ar;

    public  ArticleService(ArticleRepository ar){
       this.ar=ar;
    }

    public List<Article> getAllArticle(){
        return ar.findAll();
    }

    public Article getArticleById(Long id){
       return ar.findById(id).orElseThrow(() -> new RuntimeException(".."));
    }

    public Article CreateArticle(Article article){
       return ar.save(article);
    }

}
