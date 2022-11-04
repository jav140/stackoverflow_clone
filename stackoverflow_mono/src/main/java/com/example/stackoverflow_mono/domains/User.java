package com.example.stackoverflow_mono.domains;


import com.example.stackoverflow_mono.enums.Technology;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String displayName;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false,unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private Technology technology;

    private String image_url;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    private Integer loginTryCount;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Question> questions;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Answer> answers;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public enum Status {
        ACTIVE,
        NOT_ACTIVE,
        ACCOUNT_EXPIRED,
        CREDENTIALS_EXPIRED;

        public boolean notEquals(Status status) {

            return !this.equals(status);
        }
    }




}
