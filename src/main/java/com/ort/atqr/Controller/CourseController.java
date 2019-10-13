package com.ort.atqr.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ort.atqr.Model.*;
import com.ort.atqr.Service.ClassDayService;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    private final CourseService courseService;
    private final ClassDayService classDayService;
    private final ObjectMapper objectMapper;

    @Autowired
    public CourseController(CourseService courseService, ClassDayService classDayService, ObjectMapper objectMapper) {
        this.courseService = courseService;
        this.classDayService = classDayService;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course){
        Course created = courseService.create(course);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAll(){
        List<Course> courses = courseService.getAll().orElse(new ArrayList<>());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Course> get(@PathVariable Long id){
        Course course = courseService.getById(id);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Course> assignStudent(@PathVariable Long id, @RequestBody Student student){
        courseService.assignStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/professor")
    public ResponseEntity<Course> assignStudent(@PathVariable Long id, @RequestBody Professor professor){
        courseService.assignProfessor(id, professor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/class")
    public ResponseEntity<ClassDay> createClass(@PathVariable Long id){
        classDayService.create(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping(value = "/student")
    public ResponseEntity<List<Course>> getCourses(@RequestBody Student student){
        List<Course> courses = courseService.getCourses(student.getId());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
