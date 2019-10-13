package com.ort.atqr.Repository;

import com.ort.atqr.Model.Assistance;
import com.ort.atqr.Model.AssistanceStatus;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import org.postgresql.core.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>{

    @Transactional
    @Query(value = "SELECT course_id FROM student_course_intermediate WHERE student_id = ?1", nativeQuery = true)
    List<Long> getStudentCoursesById(Long id);

    //@Query(nativeQuery = true, value = "SELECT assistanceStatus from ")
    //public List<AssistanceStatus> findAssistanceStatusByStudent(Student student);

}
