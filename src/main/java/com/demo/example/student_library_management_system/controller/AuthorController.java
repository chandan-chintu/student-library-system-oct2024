package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.dto.AuthorRequestDto;
import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.service.AuthorService;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/save")
    public String saveAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        String response = authorService.addAuthor(authorRequestDto);
        return response;
    }
}
