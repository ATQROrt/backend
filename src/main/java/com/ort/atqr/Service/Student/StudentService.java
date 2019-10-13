package com.ort.atqr.Service.Student;

import com.ort.atqr.Model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<Student> login(Student student);

    Optional<Student> updateStudent(Student student);

    Student getStudentById(Long id);

    Student createNewStudent(Student student);

    void deleteStudent(Long id);

    Optional<List<Student>> getAll();

}
