package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/*
class-> class->extedns
interface -> class-> implements
interafce -> interface -> extends
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
