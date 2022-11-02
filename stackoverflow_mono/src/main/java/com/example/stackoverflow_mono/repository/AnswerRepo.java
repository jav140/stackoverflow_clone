package com.example.stackoverflow_mono.repository;

import com.example.stackoverflow_mono.domains.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer,Long>, GenericRepository {

    @Query("select u from Answer u where u.question.id=:id" )
    List<Answer> findAllByQuestionId(Long id);
}
