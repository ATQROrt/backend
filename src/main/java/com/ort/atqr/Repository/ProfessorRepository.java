package com.ort.atqr.Repository;

import com.ort.atqr.Model.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
    Professor findProfessorByDocumentAndPassword(Long document, String password);

    Optional<Professor> findProfessorByDocumentOrMail(Long document, String mail);

    @Transactional
    @Query(value = "SELECT id FROM course WHERE professor_id = ?1 LIMIT 1", nativeQuery = true)
    Long getProfessorCourses(Long id);
}
