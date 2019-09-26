package com.ort.atqr.Service;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor login(Professor professor) {
        return professorRepository.findProfessorByDocumentAndPassword(professor.getDocument(), professor.getPassword());
    }

    public Optional<Professor> updateProfessor(Professor professor) {
        Professor std = professorRepository.findById(professor.getId()).orElse(null);
        if (std != null) {
            AttributeHelper.myCopyProperties(professor, std);
            professorRepository.save(std);
            return Optional.of(std);
        } else {
            return Optional.empty();
        }
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    public Professor createNewProfessor(Professor professor) {
        try {
            professor.validate();
            return professorRepository.save(professor);
        } catch (InvalidInputException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }

    public Optional<List<Professor>> getAll() {
        return Optional.ofNullable((List<Professor>) professorRepository.findAll());
    }
}
