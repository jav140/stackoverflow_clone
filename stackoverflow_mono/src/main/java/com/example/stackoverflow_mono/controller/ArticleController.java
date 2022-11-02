package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController extends ApiController<ArticleService>{

    public ArticleController(ArticleService service) {
        super(service);
    }

}
