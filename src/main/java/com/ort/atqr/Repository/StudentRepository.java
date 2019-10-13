package com.ort.atqr.Repository;

import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    Student findStudentByDocumentAndPassword(Long document, String password);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Student_Course_Intermediate WHERE STUDENT_ID = ?1", nativeQuery = true)
    void deleteStudentFromCourses(Long id);

    @Transactional
    @Query(value = "SELECT course_id FROM student_course_intermediate WHERE student_id = ?1", nativeQuery = true)
    List<Course> getCourses(Long id);

}

