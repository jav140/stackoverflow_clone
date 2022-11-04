package com.example.stackoverflow_mono.controller;

import com.example.stackoverflow_mono.dto.article.ArticleCreateDto;
import com.example.stackoverflow_mono.dto.article.ArticleDto;
import com.example.stackoverflow_mono.dto.article.ArticleUpdateDto;
import com.example.stackoverflow_mono.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController extends ApiController<ArticleService>{

    public ArticleController(ArticleService service) {
        super(service);
    }

    @PostMapping("/articleCreate")
    public ResponseEntity<Long> createArticle(@Valid @RequestBody ArticleCreateDto dto){
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/articleUpdate")
    public ResponseEntity<String> updateArticle(@Valid @RequestBody ArticleUpdateDto dto){
        service.update(dto);
        return ResponseEntity.ok("Article updated");
    }

    @GetMapping("/getArticleById{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id){
        return ResponseEntity.ok(service.get(id));
    }

    @GetMapping("/getAllArticle")
    public ResponseEntity<List<ArticleDto>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @DeleteMapping("/articleDelete{articleId}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long articleId){
        service.delete(articleId);
        return ResponseEntity.ok().build();
    }



}
