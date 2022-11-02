package com.example.stackoverflow_mono.service;

import com.example.stackoverflow_mono.dto.answer.AnswerCreateDto;
import com.example.stackoverflow_mono.dto.answer.AnswerDto;
import com.example.stackoverflow_mono.dto.answer.AnswerUpdateDto;
import com.example.stackoverflow_mono.dto.article.ArticleCreateDto;
import com.example.stackoverflow_mono.dto.article.ArticleDto;
import com.example.stackoverflow_mono.dto.article.ArticleUpdateDto;
import com.example.stackoverflow_mono.mapper.AnswerMapper;
import com.example.stackoverflow_mono.mapper.ArticleMapper;
import com.example.stackoverflow_mono.repository.AnswerRepo;
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
        return null;
    }

    @Override
    public void delete(@NonNull Long aLong) {

    }

    @Override
    public void update(@NonNull ArticleUpdateDto dto) {

    }

    @Override
    public List<ArticleDto> getAll() {
        return null;
    }

    @Override
    public ArticleDto get(@NonNull Long aLong) {
        return null;
    }
}
