package com.example.stackoverflow_mono.service;


import com.example.stackoverflow_mono.dto.answer.AnswerCreateDto;
import com.example.stackoverflow_mono.dto.answer.AnswerDto;
import com.example.stackoverflow_mono.dto.answer.AnswerUpdateDto;
import com.example.stackoverflow_mono.dto.question.QuestionCreateDto;
import com.example.stackoverflow_mono.dto.question.QuestionDto;
import com.example.stackoverflow_mono.dto.question.QuestionUpdateDto;
import com.example.stackoverflow_mono.mapper.AnswerMapper;
import com.example.stackoverflow_mono.mapper.QuestionMapper;
import com.example.stackoverflow_mono.repository.AnswerRepo;
import com.example.stackoverflow_mono.repository.QuestionRepo;
import org.springframework.stereotype.Service;

@Service
public interface AnswerService extends AbstractService<AnswerRepo, AnswerMapper>
        implements GenericCrudService<Long, AnswerDto, AnswerCreateDto, AnswerUpdateDto> {
}
