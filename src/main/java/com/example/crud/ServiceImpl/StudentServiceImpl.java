package com.example.crud.ServiceImpl;

import com.example.crud.Dto.StudentDto;
import com.example.crud.Model.Student;
import com.example.crud.Service.StudentService;
import com.example.crud.repository.CrudRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private CrudRepo crudRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> studentList = crudRepo.findAll();
        List<StudentDto> studentDtos = Arrays.asList(modelMapper.map(studentList,StudentDto[].class));
        System.out.println(studentList);
        return studentDtos;
    }

    @Override
    public void addStudent(Student student) {

        crudRepo.save(student);
    }

    @Override
    public StudentDto findById(int id) {
        Student student = crudRepo.findById(id).get();
        StudentDto studentDto = this.modelMapper.map(student,StudentDto.class);
        return studentDto;
    }

    //update the existing fields to defualt value, null for string, 0 for int
    @Override
    public Student updateStudent(Student student, int id) {
        crudRepo.save(student);
        return student;
    }


    //set only the provided fields, keep the existing fields unchanged
    @Override
    public Student updateStudentPatch(Student student, int id) {
        Student sUpdated = crudRepo.findById(id).get();

        if(student.getStudentName() != null){
            sUpdated.setStudentName(student.getStudentName());
        }
        if(student.getStudentAge() != 0){
            sUpdated.setStudentAge(student.getStudentAge());
        }
        crudRepo.save(sUpdated);
        return sUpdated;
    }
}
