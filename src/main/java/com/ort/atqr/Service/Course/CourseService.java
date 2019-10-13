package com.ort.atqr.Service.Course;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Professor;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Repository.CourseRepository;
import com.ort.atqr.Service.Professor.ProfessorService;
import com.ort.atqr.Service.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final ProfessorService professorService;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentService studentService, ProfessorService professorService) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.professorService = professorService;
    }

    public Course create(Course course) {
        try {
            course.validate();
            return courseRepository.save(course);
        } catch (InvalidInputException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<List<Course>> getAll() {
        return Optional.ofNullable((List<Course>) courseRepository.findAll());
    }

    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null) ;
    }

    public void assignStudent(Long id, Student student) {
        Course course = getById(id);
        if(course != null){
            Student std = studentService.getStudentById(student.getId());
            course.addStudent(std);
            courseRepository.save(course);
        }
    }


    public List<Course> getCourses(Long id) {
        List<Course> courses = new ArrayList<>();
        List<Long> coursesIds = courseRepository.getStudentCoursesById(id);

        for(Long courseId : coursesIds){
            courses.add(getById(courseId));
        }

        return courses;
    }

    public void assignProfessor(Long id, Professor professor) {
        Course course = getById(id);
        if(course != null){
            Professor prof = professorService.getProfessorById(professor.getId());
            course.setProfessor(prof);
            courseRepository.save(course);
        }
    }


    /*
    public Integer assistancePercentage(Student student, Long id){
        Course course = getById(id);

        if(course.getClassDayList().isEmpty()){
            throw new IllegalArgumentException("The classday list can't be empty. ");
        }

        int presentClassDays = 0;
        for(ClassDay classDay : course.getClassDayList()){
            classDay.getAssistanceList().findAssistanceStatusByStudent(student)
        }
            if(classDayList.get(i).getAssistanceList(). == AssistanceStatus.PRESENT){
                presentClassDays++;
        }
        return (allClassDays*presentClassDays)/100;
    }
*/
}
