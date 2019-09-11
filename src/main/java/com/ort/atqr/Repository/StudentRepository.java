package com.ort.atqr.Repository;

import com.ort.atqr.Model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findByDocument(Long document);
    List<Student> findByfirstNameAndLastNameOrderByDocument(String firstName, String lastName);
    Student findStudentByDocumentAndPassword(Long document, String password);
}
