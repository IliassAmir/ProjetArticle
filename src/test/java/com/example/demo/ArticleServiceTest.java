package com.example.demo;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.service.ArticleService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class ArticleServiceTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleService articleService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllArticle() {
        // Préparer des articles fictifs
        Article a1 = new Article();
        a1.setId(1L);
        a1.setTitle("Titre 1");

        Article a2 = new Article();
        a2.setId(2L);
        a2.setTitle("Titre 2");

        List<Article> mockArticles = Arrays.asList(a1, a2);

        // Quand findAll() est appelé, retourner la liste fictive
        when(articleRepository.findAll()).thenReturn(mockArticles);

        // Appeler la méthode du service
        List<Article> result = articleService.getAllArticle();

        // Vérifier
        assertEquals(2, result.size());
        assertEquals("Titre 1", result.get(0).getTitle());
        verify(articleRepository, times(1)).findAll();
    }

    @Test
    void testGetArticleByIdFound() {
        Article a = new Article();
        a.setId(1L);
        a.setTitle("Titre 1");

        when(articleRepository.findById(1L)).thenReturn(Optional.of(a));

        Article result = articleService.getArticleById(1L);

        assertNotNull(result);
        assertEquals("Titre 1", result.getTitle());
        verify(articleRepository, times(1)).findById(1L);
    }

    @Test
    void testGetArticleByIdNotFound() {
        when(articleRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> articleService.getArticleById(1L));
        verify(articleRepository, times(1)).findById(1L);
    }
}
