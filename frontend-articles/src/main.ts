import { bootstrapApplication } from '@angular/platform-browser';
import { ArticleComponent } from './app/article/article.component';
import { provideHttpClient } from '@angular/common/http';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';

bootstrapApplication(ArticleComponent, {
  providers: [
    provideHttpClient(),             // rend HttpClient disponible globalement
    importProvidersFrom(FormsModule) // rend FormsModule disponible
  ]
})
.catch(err => console.error(err));
