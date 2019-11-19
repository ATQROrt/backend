package com.ort.atqr.Service.Professor;

import com.ort.atqr.Model.Professor;

import java.util.List;
import java.util.Optional;

public interface ProfessorService {

    Optional<Professor> updateProfessor(Professor professor);

    Professor getProfessorById(Long id);

    Professor createNewProfessor(Professor professor);

    void deleteProfessor(Long id);

    List<Professor> getAll();
}
