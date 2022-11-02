package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.dto.answer.AnswerCreateDto;
import com.example.stackoverflow_mono.dto.answer.AnswerDto;
import com.example.stackoverflow_mono.dto.answer.AnswerUpdateDto;

import com.example.stackoverflow_mono.service.AnswerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/answer")
public class AnswerController extends ApiController<AnswerService> {

    public AnswerController(AnswerService service) {
        super(service);
    }

    @PostMapping("/answerCreate{questionId}")
    public ResponseEntity<Long> create(@RequestBody @Valid AnswerCreateDto dto, @PathVariable Long questionId){
        return ResponseEntity.ok(service.create(dto,questionId));
    }

    @DeleteMapping("/answerDelete{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/answerEdit")
    public ResponseEntity<Void> edit(@RequestBody @Valid AnswerUpdateDto dto){
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllAnswers")
    public ResponseEntity<List<AnswerDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getOneAnswerById{id}")
    public ResponseEntity<AnswerDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/answerLike{answerId}")
    public ResponseEntity<Void> like(@PathVariable Long answerId){
        service.like(answerId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/answerDisLike{answerId}")
    public ResponseEntity<Void> disLike(@PathVariable Long answerId){
        service.dislike(answerId);
        return ResponseEntity.ok().build();
    }



}
