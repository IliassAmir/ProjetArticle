package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity 

public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    private Long id;
    
    @NotNull
    @Column(nullable= false)
    @Size(min = 3 , max = 100)
    private String title;

    @NotNull
    @Column(nullable= false)
    @Size(min = 5)
    private String content;

    public Article(){};

    public Article(String title, String content)
    {
     this.title=title;
     this.content=content;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

