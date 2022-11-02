package com.example.stackoverflow_mono.dto.answer;

import com.example.stackoverflow_mono.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerUpdateDto extends GenericDto {

    @NotBlank(message = "answer id cannot be empty")
    private Long id;

    @NotBlank(message = "answer body cannot be empty")
    private String body;

}
