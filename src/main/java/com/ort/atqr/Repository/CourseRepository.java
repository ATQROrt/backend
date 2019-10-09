package com.ort.atqr.Repository;

import com.ort.atqr.Model.Assistance;
import com.ort.atqr.Model.AssistanceStatus;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import org.postgresql.core.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>{

    //@Query(nativeQuery = true, value = "SELECT assistanceStatus from ")
    //public List<AssistanceStatus> findAssistanceStatusByStudent(Student student);

}
