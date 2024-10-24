package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(nullable = false)
    private int pages;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "issued_to_student", nullable = false)
    private boolean issuedToStudent;
}
