package com.example.stackoverflow_mono.repository;

import com.example.stackoverflow_mono.domains.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Long>, GenericRepository {

}
