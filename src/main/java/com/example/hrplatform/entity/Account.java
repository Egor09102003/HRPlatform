package com.example.hrplatform.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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

    String surname;

    String name;

    String patronymic;

    String male;

    Integer age;

    String phone;

    String mail;

    @OneToOne()
    @JoinColumn(name = "resume_id", referencedColumnName = "id")
    @JsonBackReference
    Resume resume;

}
