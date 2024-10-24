package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.CardStatus;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.awt.*;
import java.util.Date;

@Data
@Entity
@Table(name = "card")
public class Card {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "card_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @Column(name = "created_date", nullable = false)
    @CreationTimestamp // it adds auto time when card is created
    private Date createdDate;

    @Column(name = "updated_date", nullable = false)
    @UpdateTimestamp // it adds the time when card is updated
    private Date updatedDate;
}
