package com.example.stackoverflow_mono.repository;

import com.example.stackoverflow_mono.domains.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepo extends JpaRepository<Article,Long>, GenericRepository {
}
