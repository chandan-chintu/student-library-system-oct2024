package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.controller.StudentController;
import com.demo.example.student_library_management_system.converters.StudentConverter;
import com.demo.example.student_library_management_system.dto.StudentRequestDto;
import com.demo.example.student_library_management_system.enums.CardStatus;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Student;
import com.demo.example.student_library_management_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(StudentRequestDto studentRequestDto){
        Student student  = StudentConverter.convertStudentRequestDtoToStudent(studentRequestDto);
        // whenever the student is created card is also created for that student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVE);
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student and card are created";


    }

    public List<Student> getAll(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student getStudentById(int studentId){
        Student student = studentRepository.findById(studentId).get();
        return student;
    }

    public String deleteStudentById(int studentId){
        studentRepository.deleteById(studentId);
        return "student got deleted";
    }

    public String countStudent(){
        long totalCount = studentRepository.count();
        return "The total number of students present is : "+totalCount;
    }

    public String updateStudent(StudentRequestDto studentRequestDto, int studentId){
        Student student = getStudentById(studentId);
        if(student!=null){
            student.setName(studentRequestDto.getName());
            student.setMobile(studentRequestDto.getMobile());
            student.setEmail(studentRequestDto.getEmail());
            student.setAge(studentRequestDto.getAge());
            student.setAddress(studentRequestDto.getAddress());
            studentRepository.save(student);
            return "student updated successfully";
        }else{
            return "no student found cannot update";
        }
    }

}
