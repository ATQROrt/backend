package com.ort.atqr.Service.Course;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.*;
import com.ort.atqr.Repository.AssistanceRepository;
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
    private final AssistanceRepository assistanceRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository, StudentService studentService, ProfessorService professorService, AssistanceRepository assistanceRepository) {
        this.courseRepository = courseRepository;
        this.studentService = studentService;
        this.professorService = professorService;
        this.assistanceRepository = assistanceRepository;
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

    public List<CoursePercentage> getStudentCoursesWithPercentage(Long studentId){
        List<CoursePercentage> courses = new ArrayList<>();

        List<Long> coursesIds = courseRepository.getStudentCoursesById(studentId);

        for(Long courseId : coursesIds){
            StudentCourse studentCourse = new StudentCourse(studentId, courseId);
            CoursePercentage coursePercentage = new CoursePercentage(getById(courseId), studentHistoryPercentage(studentCourse));
            courses.add(coursePercentage);
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

    public List<Course> getProfessorCourses(Long id) {
        List<Course> courses = new ArrayList<>();
        List<Long> coursesIds = courseRepository.getProfessorCourses(id);

        for(Long courseId : coursesIds){
            courses.add(getById(courseId));
        }

        return courses;
    }

    public void studentAssistance(StudentCourse studentCourse) {
        Course course = getById(studentCourse.getCourseId());
        ClassDay classDay = course.getClassDayList().get(course.getClassDayList().size() - 1);

        Assistance assistance = new Assistance();
        assistance.setStudent(studentService.getStudentById(studentCourse.getStudentId()));
        assistance.setAssistanceStatus(AssistanceStatus.PRESENT);
        classDay.addAssistance(assistance);
        assistanceRepository.save(assistance);
        courseRepository.save(course);
    }

    public List<Student> grabAllPresentStudents(Long courseId){
        Course course = getById(courseId);
        ClassDay classDay = course.getClassDayList().get(course.getClassDayList().size() - 1);

        List<Student> students = new ArrayList<>();
        for (Long id : assistanceRepository.grabAllStudentIds(classDay.getId())){
            students.add(studentService.getStudentById(id));
        }
        return students;
    }

    public Integer studentHistoryPercentage(StudentCourse studentCourse){
        List<DateAssistance> history = getStudentHistory(studentCourse);
        if(history.isEmpty()){
            return 0;
        }

        int presentCounter = 0;

        for(DateAssistance dateAssistance : history){
            if(dateAssistance.getAssistanceStatus() == AssistanceStatus.PRESENT){
                presentCounter++;
            }
        }

        return presentCounter*100/history.size();
    }

    public List<DateAssistance> getStudentHistory(StudentCourse studentCourse){
        List<DateAssistance> history = new ArrayList<>();
        Course course = getById(studentCourse.getCourseId());

        for(ClassDay classDay : course.getClassDayList()){
            for(Assistance assistance : classDay.getAssistanceList()){
                //TODO Remover el TRY CATCH, dejar solo lo de adentro.
                try{
                    if(assistance.getStudent().getId().equals(studentCourse.getStudentId())){
                        history.add(new DateAssistance(classDay.getDate(), assistance.getAssistanceStatus(), classDay.getCancelled()));
                    }
                } catch (Exception e){

                }
            }
        }

        return history;
    }
}
