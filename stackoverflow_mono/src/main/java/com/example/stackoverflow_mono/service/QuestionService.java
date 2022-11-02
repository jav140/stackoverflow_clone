package com.example.stackoverflow_mono.service;


import com.example.stackoverflow_mono.domains.Answer;
import com.example.stackoverflow_mono.domains.Question;
import com.example.stackoverflow_mono.dto.question.QuestionCreateDto;
import com.example.stackoverflow_mono.dto.question.QuestionDto;
import com.example.stackoverflow_mono.dto.question.QuestionUpdateDto;
import com.example.stackoverflow_mono.mapper.QuestionMapper;
import com.example.stackoverflow_mono.repository.AnswerRepo;
import com.example.stackoverflow_mono.repository.QuestionRepo;
import com.example.stackoverflow_mono.utils.BaseUtils;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService extends AbstractService<QuestionRepo, QuestionMapper>
implements GenericCrudService<Long, QuestionDto, QuestionCreateDto, QuestionUpdateDto>{


    private final AnswerRepo answerRepo;
    public QuestionService(QuestionRepo repository, QuestionMapper mapper, BaseUtils utils, AnswerRepo answerRepo) {
        super(repository, mapper, utils);
        this.answerRepo = answerRepo;
    }

    @Override
    public Long create(@NonNull QuestionCreateDto dto) {
        Question question = mapper.fromCreateDto(dto);
        Question question1 = repository.save(question);
        return question1.getId();
    }

    @Override
    public void delete(@NonNull Long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(@NonNull QuestionUpdateDto dto) {
        Question question = mapper.fromUpdateDto(dto);
        repository.save(question);
    }

    @Override
    public List<QuestionDto> getAll() {
        List<Question> questionList = repository.findAll();
        return mapper.toDto(questionList);
    }

    @Override
    public QuestionDto get(@NonNull Long id) {
        Question question = repository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
        List<Answer> answerList = answerRepo.findAllByQuestionId(id);
        question.setAnswerList(answerList);
        QuestionDto questionDto = mapper.toDto(question);
        questionDto.setAnswers(answerList);
        return questionDto;
    }
}
