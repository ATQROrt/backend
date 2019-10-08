package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class Student extends User {

    private List<Course> studentCourses;

    public Student(String firstName, String lastName, Long document, String mail, Date birth, String imageUrl, String password) {
        super(firstName, lastName, document, mail, birth, imageUrl, password);
    }

    public Student() {
    }

    public List<Course> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }
}
