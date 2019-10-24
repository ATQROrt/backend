package com.ort.atqr.Service;

import com.ort.atqr.Model.*;
import com.ort.atqr.Repository.ClassDayRepository;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassDayService {

    private final ClassDayRepository classDayRepository;
    private final CourseService courseService;

    @Autowired
    public ClassDayService(ClassDayRepository classDayRepository, CourseService courseService) {
        this.classDayRepository = classDayRepository;
        this.courseService = courseService;
    }

    public ClassDay create(Long courseId){
        Course course = courseService.getById(courseId);
        ClassDay classDay = new ClassDay();
        List<Assistance> assistances = new ArrayList<>();
        for(Student student : course.getStudents()){
            Assistance assistance = new Assistance();
            assistance.setStudent(student);
            assistance.setAssistanceStatus(AssistanceStatus.ABSENT);
        }
        classDay.setAssistanceList(assistances);
        course.addClass(classDay);
        return classDayRepository.save(classDay);
    }

    public List<Assistance> endClass(Long id) {
        Optional<ClassDay> classDay = classDayRepository.findById(id);
        if(classDay.isPresent()){
            return classDay.get().getAssistanceList();
        }
        return new ArrayList<>();
    }
}
