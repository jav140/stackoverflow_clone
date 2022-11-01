package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.dto.question.QuestionCreateDto;
import com.example.stackoverflow_mono.dto.question.QuestionDto;
import com.example.stackoverflow_mono.dto.question.QuestionUpdateDto;
import com.example.stackoverflow_mono.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController extends ApiController<QuestionService>{


    public QuestionController(QuestionService service) {
        super(service);
    }

    @PostMapping("/questionCreate")
    public ResponseEntity<Long> create(@RequestBody @Valid QuestionCreateDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @DeleteMapping("/questionDelete{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/questionEdit")
    public ResponseEntity<Void> edit(@RequestBody @Valid QuestionUpdateDto dto){
        service.update(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getAllQuestion")
    public ResponseEntity<List<QuestionDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/getOneQuestion{id}")
    public ResponseEntity<QuestionDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }




}
