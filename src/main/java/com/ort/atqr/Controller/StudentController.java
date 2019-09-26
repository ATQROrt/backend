package com.ort.atqr.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    private final StudentService studentService;
    private final ObjectMapper objectMapper;

    @Autowired
    public StudentController(StudentService studentService, ObjectMapper objectMapper) {
        this.studentService = studentService;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Optional<Student>> login(@RequestBody Student student) {
        Optional<Student> logged = studentService.login(student);
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> updateStudent(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        Student modified = objectMapper.convertValue(update, Student.class);
        modified.setId(id);
        Optional<Student> newStudent = studentService.updateStudent(modified);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.createNewStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        studentService.deleteStudent(student.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student studentFinded = studentService.getStudentById(id);
        return new ResponseEntity<>(studentFinded, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Optional<List<Student>>> getAllStudents() {
        Optional<List<Student>> students = studentService.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
