package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.domains.Article;

import com.example.stackoverflow_mono.dto.article.ArticleCreateDto;
import com.example.stackoverflow_mono.dto.article.ArticleDto;
import com.example.stackoverflow_mono.dto.article.ArticleUpdateDto;
import com.example.stackoverflow_mono.mapper.ArticleMapper;
import com.example.stackoverflow_mono.repository.ArticleRepo;
import com.example.stackoverflow_mono.utils.BaseUtils;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService extends AbstractService<ArticleRepo, ArticleMapper>
        implements GenericCrudService<Long, ArticleDto, ArticleCreateDto, ArticleUpdateDto> {
    public ArticleService(ArticleRepo repository, ArticleMapper mapper, BaseUtils utils) {
        super(repository, mapper, utils);
    }

    @Override
    public Long create(@NonNull ArticleCreateDto dto) {
        Article article = mapper.fromCreateDto(dto);
        repository.save(article);
        return article.getId();
    }

    @Override
    public void delete(@NonNull Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(@NonNull ArticleUpdateDto dto) {
        Article article = mapper.fromUpdateDto(dto);
        repository.save(article);
    }

    @Override
    public List<ArticleDto> getAll() {
        List<Article> articleList = repository.findAll();
        return mapper.toDto(articleList);
    }

    @Override
    public ArticleDto get(@NonNull Long id) {
        Article article = repository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        return mapper.toDto(article);
    }
}
