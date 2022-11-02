package com.example.stackoverflow_mono.mapper;

import com.example.stackoverflow_mono.domains.Article;
import com.example.stackoverflow_mono.dto.article.ArticleCreateDto;
import com.example.stackoverflow_mono.dto.article.ArticleDto;
import com.example.stackoverflow_mono.dto.article.ArticleUpdateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends BaseMapper<Article, ArticleDto, ArticleCreateDto, ArticleUpdateDto>{
}
