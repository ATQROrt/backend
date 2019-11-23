package com.ort.atqr.Service.Professor;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Repository.ProfessorRepository;
import com.ort.atqr.Service.AttributeHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService{

    private ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor login(Professor professor) {
        return professorRepository.findProfessorByDocumentAndPassword(professor.getDocument(), professor.getPassword());
    }

    public Optional<Professor> updateProfessor(Professor professor) {
        Professor std = professorRepository.findById(professor.getId()).orElse(null);
        if (std != null) {
            AttributeHelper.myCopyProperties(professor, std);
            validate(std);
            professorRepository.save(std);
            return Optional.of(std);
        } else {
            return Optional.empty();
        }
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id).orElse(null);
    }

    private void validate(Professor professor){
        try{
            professor.validate();
        } catch(InvalidInputException e){
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Professor createNewProfessor(Professor professor) {
        validate(professor);
        professorRepository.findProfessorByDocumentOrMail(professor.getDocument(), professor.getMail()).ifPresent(x ->
        {throw new IllegalArgumentException("Ya existe un profesor con este mail o documento");});
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        Long count = professorRepository.getProfessorCourses(id);
        if(count == null || count < 1)
            professorRepository.deleteById(id);
        else
            throw new IllegalArgumentException("El profesor es parte de diversos cursos");
    }

    public List<Professor> getAll() {
        return ((List<Professor>) professorRepository.findAll()).stream().filter(x -> !x.getIsAdmin()).collect(Collectors.toList());
    }
}
