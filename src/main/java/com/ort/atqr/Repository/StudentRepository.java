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

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Assistance WHERE STUDENT_ID = ?1", nativeQuery = true)
    void deleteStudentFromAssistance(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM class_day_assistance_list WHERE assistance_list_id = ?1", nativeQuery = true)
    void deleteAssistance(Long id);

    @Query(value = "SELECT id FROM ASSISTANCE WHERE STUDENT_ID = ?1", nativeQuery = true)
    List<Long> findAssistanceId(Long id);

    Optional<Student> findStudentByDocumentOrMail(Long document, String mail);
}

