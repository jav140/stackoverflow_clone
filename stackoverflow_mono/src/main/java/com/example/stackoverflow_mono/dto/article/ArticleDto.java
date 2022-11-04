package com.example.stackoverflow_mono.dto.article;

import com.example.stackoverflow_mono.domains.Auditable;
import com.example.stackoverflow_mono.dto.GenericDto;
import com.example.stackoverflow_mono.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto extends GenericDto {

    private Long id;

    private String title;

    private String body;

    private Technology type;

    private Auditable auditable;

}
