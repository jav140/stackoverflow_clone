package com.example.stackoverflow_mono.dto.answer;

import com.example.stackoverflow_mono.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCreateDto implements Dto {

    @NotBlank(message = "answer body cannot be empty")
    private String body;

}
