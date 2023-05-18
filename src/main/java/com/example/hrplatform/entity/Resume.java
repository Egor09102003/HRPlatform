package com.example.hrplatform.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "Resume")
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_sequence")
    @SequenceGenerator(name = "hibernate_sequence", sequenceName = "hibernate_sequence", allocationSize = 10)
    Long id;

    String experience;

    String lastWorkPlace;

    Integer salary;

    Boolean car;

    Integer hoursPerWeek;

    String description;

    @OneToOne(mappedBy = "resume")
    @JsonManagedReference
    Account account;
}
