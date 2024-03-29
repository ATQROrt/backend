package com.ort.atqr.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Service.Professor.ProfessorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/professor")
public class ProfessorController {
    private final ProfessorServiceImpl professorServiceImpl;
    private final ObjectMapper objectMapper;

    @Autowired
    public ProfessorController(ProfessorServiceImpl professorServiceImpl, ObjectMapper objectMapper) {
        this.professorServiceImpl = professorServiceImpl;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Professor> professorLogIn(@RequestBody Professor professor) {
        Professor logged = professorServiceImpl.login(professor);
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Professor>> updateProfessor(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        Professor modified = objectMapper.convertValue(update, Professor.class);
        modified.setId(id);
        Optional<Professor> newProfessor = professorServiceImpl.updateProfessor(modified);
        return new ResponseEntity<>(newProfessor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor newProfessor = professorServiceImpl.createNewProfessor(professor);
        return new ResponseEntity<>(newProfessor, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Professor> deleteProfessor(@PathVariable Long id) {
        professorServiceImpl.deleteProfessor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Professor professorFinded = professorServiceImpl.getProfessorById(id);
        return new ResponseEntity<>(professorFinded, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllStudents() {
        List<Professor> professors = professorServiceImpl.getAll();
        return new ResponseEntity<>(professors, HttpStatus.OK);
    }
}
