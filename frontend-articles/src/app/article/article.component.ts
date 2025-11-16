import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ArticleService } from '../services/article.service';
import { Article } from './article';

@Component({
  selector: 'app-article',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {
  articles: Article[] = [];
  newArticle: Article = { title: '', content: '' };

  constructor(private articleService: ArticleService) {}

  ngOnInit(): void {
    this.loadArticles();
  }

  loadArticles(): void {
    this.articleService.getArticles().subscribe(data => this.articles = data);
  }

  // hadi houwal code dial nouvelle branche
  // new comm
  // newwwwcommm
  // .........
  /// hadi hia hia hia
  //dgfdgfdgfdg
  createArticle(): void {
    this.articleService.createArticle(this.newArticle).subscribe(res => {
      this.loadArticles();
      this.newArticle = { title: '', content: '' };
    });
  }
}
