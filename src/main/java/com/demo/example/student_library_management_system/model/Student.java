package com.demo.example.student_library_management_system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "student")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private int age;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false, unique = true)
    private String mobile;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;
}
