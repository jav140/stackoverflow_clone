package com.example.stackoverflow_mono.mapper;

import com.example.stackoverflow_mono.domains.Question;
import com.example.stackoverflow_mono.dto.question.QuestionCreateDto;
import com.example.stackoverflow_mono.dto.question.QuestionDto;
import com.example.stackoverflow_mono.dto.question.QuestionUpdateDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<Question, QuestionDto, QuestionCreateDto, QuestionUpdateDto> {
}
