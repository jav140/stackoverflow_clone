package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.service.AnswerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/answer")
public class AnswerController extends ApiController<AnswerService> {

    public AnswerController(AnswerService service) {
        super(service);
    }
}
