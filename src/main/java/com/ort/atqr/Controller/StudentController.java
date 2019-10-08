package com.ort.atqr.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.Asignature;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Service.Student.StudentServiceImpl;
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
    private final StudentServiceImpl studentServiceImpl;
    private final ObjectMapper objectMapper;

    @Autowired
    public StudentController(StudentServiceImpl studentServiceImpl, ObjectMapper objectMapper) {
        this.studentServiceImpl = studentServiceImpl;
        this.objectMapper = objectMapper;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Optional<Student>> login(@RequestBody Student student) {
        Optional<Student> logged = studentServiceImpl.login(student);
        return new ResponseEntity<>(logged, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Optional<Student>> updateStudent(@PathVariable Long id, @RequestBody Map<String, Object> update) {
        Student modified = objectMapper.convertValue(update, Student.class);
        modified.setId(id);
        Optional<Student> newStudent = studentServiceImpl.updateStudent(modified);
        return new ResponseEntity<>(newStudent, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentServiceImpl.createNewStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Student> deleteStudent(@RequestBody Student student) {
        studentServiceImpl.deleteStudent(student.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student studentFinded = studentServiceImpl.getStudentById(id);
        return new ResponseEntity<>(studentFinded, HttpStatus.FOUND);
    }

    @GetMapping
    public ResponseEntity<Optional<List<Student>>> getAllStudents() {
        Optional<List<Student>> students = studentServiceImpl.getAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /*
    @GetMapping
    public ResponseEntity<List<Asignature>> getAllStudentAsignatures(@PathVariable Long id){
        List<Asignature> asignatures = studentServiceImpl.getStudentAsignatures(id);
        return new ResponseEntity<>(asignatures, HttpStatus.FOUND);
    }
    */

    @GetMapping
    public ResponseEntity<List<Course>> getAllStudentCourses(@PathVariable Long id){
        List<Course> courses = studentServiceImpl.getStudentCourses(id);
        return new ResponseEntity<>(courses, HttpStatus.FOUND);
    }
}
