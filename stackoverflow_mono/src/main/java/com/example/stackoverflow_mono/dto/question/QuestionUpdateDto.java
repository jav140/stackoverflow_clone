package com.example.stackoverflow_mono.dto.question;

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
public class QuestionUpdateDto extends GenericDto {

    @NotBlank(message = "title cannot be empty")
    private String title;

    @NotBlank(message = "type cannot be empty")
    private String type;

    @NotBlank(message = "body cannot be empty")
    private String body;

}
