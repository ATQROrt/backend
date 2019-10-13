package com.ort.atqr.Repository;

import com.ort.atqr.Model.*;
import org.postgresql.core.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>{

    @Transactional
    @Query(value = "SELECT course_id FROM student_course_intermediate WHERE student_id = ?1", nativeQuery = true)
    List<Long> getStudentCoursesById(Long id);

    @Transactional
    @Query(value = "SELECT id FROM course WHERE professor_id = ?1", nativeQuery = true)
    List<Long> getProfessorCourses(Long id);

}
