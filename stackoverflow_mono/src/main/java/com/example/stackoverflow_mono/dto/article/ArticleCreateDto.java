package com.example.stackoverflow_mono.dto.article;

import com.example.stackoverflow_mono.dto.Dto;
import com.example.stackoverflow_mono.enums.Technology;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreateDto implements Dto {


    private String title;

    private String body;

    private Technology type;

}
