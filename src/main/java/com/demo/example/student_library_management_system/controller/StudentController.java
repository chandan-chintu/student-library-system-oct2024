package com.demo.example.student_library_management_system.controller;

import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response = studentService.addStudent(studentRequestDto);
        return response;
    }

    @GetMapping("/findAll")
    public List<Student> getAllStudent(){
        List<Student> studentList = studentService.getAll();
        return studentList;
    }

    @GetMapping("/find/{studentid}")
    public Student getStudentById(@PathVariable("studentid") int studentId){
        Student student = studentService.getStudentById(studentId);
        return student;
    }

    @DeleteMapping("/delete/{studentid}")
    public String deleteStudentById(@PathVariable("studentid") int studentId){
        String response = studentService.deleteStudentById(studentId);
        return response;
    }

    @GetMapping("/getCount")
    public String countStudents(){
        String response = studentService.countStudent();
        return response;
    }

    @PutMapping("/update/{studentid}")
    public String updateStudent(@RequestBody StudentRequestDto studentRequestDto,@PathVariable("studentid") int studentId){
        String response = studentService.updateStudent(studentRequestDto,studentId);
        return response;
    }

    @GetMapping("/findPage")
    public List<Student> getAllStudentsWithPage(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize, @RequestParam("sortInput") String sortInput){
        List<Student> studentList = studentService.getAllStudentsByPage(pageNo,pageSize, sortInput);
        return studentList;
    }

    @GetMapping("/findByEmail")
    public Student getStudentByEmail(@RequestParam("email") String email){
        Student student = studentService.getStudentByEmail(email);
        return student;
    }

    @GetMapping("/findByEmailQuery")
    public Student getStudentByEmailQuery(@RequestParam("email") String email){
        Student student = studentService.getStudentByEmailQuery(email);
        return student;
    }
}
