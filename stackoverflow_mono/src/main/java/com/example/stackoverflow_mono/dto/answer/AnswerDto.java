package com.example.stackoverflow_mono.dto.answer;


import com.example.stackoverflow_mono.domains.Auditable;
import com.example.stackoverflow_mono.domains.Question;
import com.example.stackoverflow_mono.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto extends GenericDto{

    private String body;

    private Integer numberOfPlus;

    private Integer numberOfMinus;

    private Auditable auditable;

    private Question question;

}
