package com.example.stackoverflow_mono.dto.question;

import com.example.stackoverflow_mono.domains.Answer;
import com.example.stackoverflow_mono.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto extends GenericDto {

    private String title;

    private String type;

    private String body;

    private List<Answer> answers;

}
