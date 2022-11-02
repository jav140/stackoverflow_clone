package com.example.stackoverflow_mono.mapper;

import com.example.stackoverflow_mono.domains.Answer;
import com.example.stackoverflow_mono.dto.answer.AnswerCreateDto;
import com.example.stackoverflow_mono.dto.answer.AnswerDto;
import com.example.stackoverflow_mono.dto.answer.AnswerUpdateDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AnswerMapper extends BaseMapper<Answer, AnswerDto, AnswerCreateDto, AnswerUpdateDto> {
}
