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
    public ResponseEntity<Course> assignProfessor(@PathVariable Long id, @RequestBody Professor professor){
        courseService.assignProfessor(id, professor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/class")
    public ResponseEntity<ClassDay> createClass(@PathVariable Long id){
        ClassDay classDay = classDayService.create(id);
        return new ResponseEntity<>(classDay, HttpStatus.CREATED);
    }

    @PostMapping(value = "/student")
    public ResponseEntity<List<CoursePercentage>> getCourses(@RequestBody Student student){
        List<CoursePercentage> courses = courseService.getStudentCoursesWithPercentage(student.getId());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(value = "/professor")
    public ResponseEntity<List<Course>> getProfessorCourses(@RequestBody Professor professor){
        List<Course> courses = courseService.getProfessorCourses(professor.getId());
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping(value = "/assistance")
    public ResponseEntity<Void> studentAssistance(@RequestBody StudentCourse studentCourse){
        courseService.studentAssistance(studentCourse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/present")
    public ResponseEntity<List<Student>> grabAllPresentStudents(@PathVariable Long id){
        return new ResponseEntity<>(courseService.grabAllPresentStudents(id), HttpStatus.OK);
    }

    @PostMapping(value = "/history")
    public ResponseEntity<List<DateAssistance>> getStudentHistory(@RequestBody StudentCourse studentCourse){
        return new ResponseEntity<>(courseService.getStudentHistory(studentCourse), HttpStatus.OK);
    }

    @PostMapping(value = "/percentage")
    public ResponseEntity<Integer> getAssistancePercentage(@RequestBody StudentCourse studentCourse){
        return new ResponseEntity<>(courseService.studentHistoryPercentage(studentCourse), HttpStatus.OK);
    }

    @PostMapping(value = "/{id}/endclass")
    public ResponseEntity<List<Assistance>> endClass(@PathVariable Long id){
        List<Assistance> assistances = classDayService.endClass(id);
        return new ResponseEntity<List<Assistance>>(assistances, HttpStatus.CREATED);
    }
}
