package com.ort.atqr.Repository;

import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentByDocumentAndPassword(Long document, String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Student_Course_Intermediate WHERE STUDENT_ID = ?1", nativeQuery = true)
    void deleteStudentFromCourses(Long id);

    Optional<Student> findStudentByDocumentOrMail(Long document, String mail);
}

