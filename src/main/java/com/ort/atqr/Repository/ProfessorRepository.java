package com.ort.atqr.Repository;

import com.ort.atqr.Model.Professor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor findProfessorByDocumentAndPassword(Long document, String password);

    Optional<Professor> findProfessorByDocumentOrMail(Long document, String mail);
}
