package com.ort.atqr.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorService professorService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProfessorController(ProfessorService professorService, ObjectMapper objectMapper) {
        this.professorService = professorService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Professor> professorLogIn(@RequestBody Professor professor) {
        Professor logged = professorService.login(professor);
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Optional<Professor>> updateProfessor(@RequestBody Map<String, Object> update) {
        Professor modified = objectMapper.convertValue(update, Professor.class);
        Optional<Professor> newProfessor = professorService.updateProfessor(modified);
        return new ResponseEntity<>(newProfessor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor newProfessor = professorService.createNewProfessor(professor);
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Professor> deleteProfessor(@RequestBody Professor professor) {
        professorService.deleteProfessor(professor.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> getStudentById(@PathVariable Long id) {
        Professor professorFinded = professorService.getProfessorById(id);
        return new ResponseEntity<>(professorFinded, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Optional<List<Professor>>> getAllStudents() {
        Optional<List<Professor>> professors = professorService.getAll();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }
}
