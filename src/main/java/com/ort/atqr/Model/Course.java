package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course implements Validatable {
    @Id
    @Access(AccessType.PROPERTY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.REFRESH)
    private Asignature asignature;
    @ManyToOne
    private Professor professor;
    @OneToMany(targetEntity = ClassDay.class, fetch = FetchType.LAZY)
    private List<ClassDay> classDayList;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.REFRESH }  )
    @JoinTable(
            name = "Student_Course_Intermediate",
            joinColumns = { @JoinColumn(name = "course_id") },
            inverseJoinColumns = { @JoinColumn(name = "student_id") }
    )
    private List<Student> students;

    @Override
    public void validate() throws InvalidInputException {
        if (this.asignature == null) {
            throw new InvalidInputException(ErrorMessage.INVALID_ASSIGNATURE);
        }
    }

    public void addClass(ClassDay classDay){
        this.classDayList.add(classDay);
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

    public Asignature getAsignature() {
        return asignature;
    }

    public void setAsignature(Asignature asignature) {
        this.asignature = asignature;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<ClassDay> getClassDayList() {
        return classDayList;
    }

    public void setClassDayList(List<ClassDay> classDayList) {
        this.classDayList = classDayList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
