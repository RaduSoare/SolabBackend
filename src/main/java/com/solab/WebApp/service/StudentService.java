package com.solab.WebApp.service;

import com.solab.WebApp.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Optional<Student> getStudentById(int id);
}
