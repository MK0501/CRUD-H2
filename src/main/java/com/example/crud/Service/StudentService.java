package com.example.crud.Service;

import com.example.crud.Dto.StudentDto;
import com.example.crud.Model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    public List<StudentDto> findAllStudent();
    public void addStudent(Student student);
    public StudentDto findById(int id);
    public Student updateStudent(Student student, int id);

    public Student updateStudentPatch(Student student, int id);
}
