package com.example.stackoverflow_mono.domains;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicInsert
@DynamicUpdate
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = true)
    @ColumnDefault("0")
    private Integer numberOfPlus;

    @Column(nullable = true)
    @ColumnDefault("0")
    private Integer numberOfMinus;

    @Embedded
    private Auditable auditable;

    @ManyToOne
    @JsonBackReference
    private Question question;

    @ManyToOne
    @JsonBackReference
    private User user;

}
