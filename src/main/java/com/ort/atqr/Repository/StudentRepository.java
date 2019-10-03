package com.ort.atqr.Repository;

import com.ort.atqr.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentByDocumentAndPassword(Long document, String password);

}

