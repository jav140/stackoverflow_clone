//package com.example.stackoverflow_mono.domains;
//
//import com.example.stackoverflow_mono.enums.ERole;
//import lombok.*;
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//
//
//import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name = "roles")
//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
//@DynamicInsert
//@DynamicUpdate
//public class Role implements GrantedAuthority {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_seq_gen")
//    @SequenceGenerator(name = "role_id_seq_gen", sequenceName = "role_id_seq_generator", allocationSize = 1)
//    private Integer id;
//
//    @Enumerated(EnumType.STRING)
//    @Column(length = 20)
//    private ERole name;
//
//
//    @ManyToMany
//    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Role> roles = new HashSet<>();
//
//    public Role(ERole name) {
//        this.name = name;
//    }
//
//    @Override
//    public String getAuthority() {
//        return this.name.toString();
//    }
//}
