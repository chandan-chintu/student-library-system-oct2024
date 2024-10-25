package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "book")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Card card;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Transaction> transactionsForBook = new ArrayList<>();
}
