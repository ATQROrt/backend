package com.ort.atqr.Repository;

import com.ort.atqr.Model.ClassDay;
import com.ort.atqr.Model.StudentCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClassDayRepository extends CrudRepository<ClassDay, Long> {

}
