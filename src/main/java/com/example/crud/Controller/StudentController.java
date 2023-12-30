package com.example.crud.Controller;

import com.example.crud.Dto.StudentDto;
import com.example.crud.Model.Student;
import com.example.crud.Service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/get")
    public List<StudentDto> findStudents(){
        return studentService.findAllStudent();
    }

    @GetMapping("{id}")
    public StudentDto findStudent(@PathVariable int id){
        return studentService.findById(id);
    }

    @PostMapping("/add")
    public void addStudent(@RequestBody Student student){
         studentService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudent(student, id);
    }

    @PatchMapping("/patchUpdate")
    public Student updateStu(@RequestBody Student student, @PathVariable int id){
        return studentService.updateStudentPatch(student, id);
    }

}
