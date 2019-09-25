package com.ort.atqr.Repository;

import com.ort.atqr.Model.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

    Professor findProfessorByDocumentAndPassword(Long document, String password);

}
