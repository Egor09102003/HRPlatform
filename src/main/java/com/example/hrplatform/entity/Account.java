package com.example.hrplatform.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.lang.Nullable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String username;

    String password;

    String role;

    Boolean active;

    String surname;

    String name;

    String patronymic;

    String male;

    @Nullable
    Integer age;

    String phone;

    String mail;

    @OneToOne()
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    Resume resume;

}
