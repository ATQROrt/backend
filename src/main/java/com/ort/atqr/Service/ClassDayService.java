package com.ort.atqr.Service;

import com.ort.atqr.Model.ClassDay;
import com.ort.atqr.Model.Course;
import com.ort.atqr.Repository.ClassDayRepository;
import com.ort.atqr.Service.Course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        course.addClass(classDay);
        return classDayRepository.save(classDay);
    }

}
