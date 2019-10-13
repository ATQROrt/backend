package com.ort.atqr.Repository;

import com.ort.atqr.Model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentByDocumentAndPassword(Long document, String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Student_Course_Intermediate WHERE STUDENT_ID = ?1", nativeQuery = true)
    void deleteStudentFromCourses(Long id);

}

