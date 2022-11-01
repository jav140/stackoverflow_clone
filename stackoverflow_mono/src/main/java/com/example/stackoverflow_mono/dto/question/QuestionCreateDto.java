package com.example.stackoverflow_mono.dto.question;

import com.example.stackoverflow_mono.domains.Answer;
import com.example.stackoverflow_mono.dto.Dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionCreateDto implements Dto {

    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotBlank(message = "title cannot be empty")
    private String type;

    @NotBlank(message = "title cannot be empty")
    private String body;

    private List<Answer> answerList;

}
