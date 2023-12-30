package com.example.crud.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "studentid")
    private int id;

    @Column(name = "name")
    private String studentName;

    @Column(name = "age")
    private int StudentAge;
}
