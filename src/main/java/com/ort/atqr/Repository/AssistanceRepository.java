package com.ort.atqr.Repository;

import com.ort.atqr.Model.Assistance;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssistanceRepository extends CrudRepository<Assistance, Long> {
    @Query(value = "SELECT student_id FROM class_day_assistance_list middle join assistance a on middle.assistance_list_id = a.id where middle.class_day_id = ?1", nativeQuery = true)
    List<Long> grabAllStudentIds(Long classDayId);
}
