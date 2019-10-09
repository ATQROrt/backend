package com.ort.atqr.Service.Course;

import com.ort.atqr.Exception.InvalidInputException;
import com.ort.atqr.Model.AssistanceStatus;
import com.ort.atqr.Model.ClassDay;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Model.Student;
import com.ort.atqr.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
/*
    public void assignStudent(Long id, Student student){
        Optional<Course> course = getById(id);
        if(course.isPresent()){
            Course c = course.get();
            c.getStudentsList().add(student);
            courseRepository.save(c);
        }
    }
*/
    public Course getById(Long id) {
        return courseRepository.findById(id).orElse(null) ;
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
