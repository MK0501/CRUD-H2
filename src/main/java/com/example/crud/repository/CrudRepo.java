package com.example.crud.repository;

import com.example.crud.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepo extends JpaRepository<Student, Integer> {
}
