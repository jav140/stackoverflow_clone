package com.example.stackoverflow_mono.repository;

import com.example.stackoverflow_mono.domains.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer,Long>, GenericRepository {

}
