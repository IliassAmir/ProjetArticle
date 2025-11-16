import { Component } from '@angular/core';
import { ArticleComponent } from './article/article.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ArticleComponent],
  template: `<app-article></app-article>`,
})
export class AppRootComponent {}
