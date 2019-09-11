package com.ort.atqr.Repository;

import com.ort.atqr.Model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor findBydocument(Long document);
    List<Professor> findByfirstNameAndlastNameOrderBydocument(String firstName, String lastName);
}
