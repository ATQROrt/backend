package com.ort.atqr.Service;

import com.ort.atqr.Model.*;
import com.ort.atqr.Repository.AssistanceRepository;
import com.ort.atqr.Repository.ClassDayRepository;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class ClassDayService {

    private final ClassDayRepository classDayRepository;
    private final CourseService courseService;
    private final AssistanceRepository assistanceRepository;

    @Autowired
    public ClassDayService(ClassDayRepository classDayRepository, CourseService courseService, AssistanceRepository assistanceRepository) {
        this.classDayRepository = classDayRepository;
        this.courseService = courseService;
        this.assistanceRepository = assistanceRepository;
    }

    private boolean isSameDate(Optional<ClassDay> lastClass, ClassDay classDay){
        if(!lastClass.isPresent()) return false;

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(lastClass.get().getDate());
        cal2.setTime(classDay.getDate());
        return cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
    }

    private Optional<ClassDay> getLastClass(Course course){
        if(course.getClassDayList().isEmpty()){
            return Optional.empty();
        }
        return Optional.of(course.getClassDayList().get(course.getClassDayList().size() - 1));
    }

    public ClassDay create(Long courseId) {
        Course course = courseService.getById(courseId);
        ClassDay classDay = new ClassDay();
        Optional<ClassDay> lastClass = getLastClass(course);
        if(isSameDate(lastClass, classDay)){
            throw new IllegalArgumentException("Ya se abrio una clase hoy.");
        }

        List<Assistance> assistances = new ArrayList<>();
        for(Student student : course.getStudents()){
            Assistance assistance = new Assistance();
            assistance.setStudent(student);
            assistance.setAssistanceStatus(AssistanceStatus.ABSENT);
            assistanceRepository.save(assistance);
            assistances.add(assistance);
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
