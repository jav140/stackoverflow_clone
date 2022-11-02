package com.example.stackoverflow_mono.service;


import com.example.stackoverflow_mono.domains.Answer;
import com.example.stackoverflow_mono.domains.Question;
import com.example.stackoverflow_mono.dto.answer.AnswerCreateDto;
import com.example.stackoverflow_mono.dto.answer.AnswerDto;
import com.example.stackoverflow_mono.dto.answer.AnswerUpdateDto;
import com.example.stackoverflow_mono.mapper.AnswerMapper;
import com.example.stackoverflow_mono.repository.AnswerRepo;
import com.example.stackoverflow_mono.repository.QuestionRepo;
import com.example.stackoverflow_mono.utils.BaseUtils;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends AbstractService<AnswerRepo, AnswerMapper>
        implements GenericCrudService<Long, AnswerDto, AnswerCreateDto, AnswerUpdateDto> {

    private final QuestionRepo questionRepo;
    public AnswerService(AnswerRepo repository, AnswerMapper mapper, BaseUtils utils, QuestionRepo questionRepo) {
        super(repository, mapper, utils);
        this.questionRepo = questionRepo;
    }


    public Long create(@NonNull AnswerCreateDto dto, Long questionId) {
        Question question = questionRepo.findById(questionId).orElseThrow(() -> new RuntimeException("Question not found"));
        Answer answer = mapper.fromCreateDto(dto);
        answer.setNumberOfMinus(0);
        answer.setNumberOfPlus(0);
        answer.setQuestion(question);
        question.getAnswerList().add(answer);
        questionRepo.save(question);
        return repository.save(answer).getId();
    }

    @Override
    public Long create(@NonNull AnswerCreateDto dto) {
        return null;
    }

    @Override
    public void delete(@NonNull Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(@NonNull AnswerUpdateDto dto) {
        repository.findById(dto.getId()).orElseThrow(() -> new RuntimeException("answer not found"));
        Answer answer = mapper.fromUpdateDto(dto);
        repository.save(answer);
    }

    @Override
    public List<AnswerDto> getAll() {
        List<Answer> answerList = repository.findAll();
        return mapper.toDto(answerList);
    }

    @Override
    public AnswerDto get(@NonNull Long id) {
        Answer answer = repository.findById(id).orElseThrow(() -> new RuntimeException("answer not found"));
        return mapper.toDto(answer);
    }

    public void like(Long answerId) {
        Answer answer = repository.
                findById(answerId).orElseThrow(() -> new RuntimeException("answer not found"));
        answer.setNumberOfPlus(answer.getNumberOfPlus()+1);
        repository.save(answer);
    }

    public void dislike(Long answerId) {
        Answer answer = repository.
                findById(answerId).orElseThrow(() -> new RuntimeException("answer not found"));
        answer.setNumberOfMinus(answer.getNumberOfMinus()+1);
        repository.save(answer);
    }
}
