package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.dto.BookRequestDto;
import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.service.BookService;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/save")
    public String saveBook(@RequestBody BookRequestDto bookRequestDto){
        String response = bookService.addBook(bookRequestDto);
        return response;
    }
}
