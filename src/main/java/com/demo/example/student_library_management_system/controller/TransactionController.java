package com.demo.example.student_library_management_system.controller;


import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.dto.TransactionRequestDto;
import com.demo.example.student_library_management_system.service.StudentService;
import com.demo.example.student_library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/api")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public String saveTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
        String response = transactionService.addTransaction(transactionRequestDto);
        return response;
    }
}
