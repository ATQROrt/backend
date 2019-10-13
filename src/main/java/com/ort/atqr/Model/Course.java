package com.ort.atqr.Model;

import com.ort.atqr.Exception.ErrorMessage;
import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Course implements Validatable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Asignature asignature;
    @OneToOne
    private Professor professor;
    @OneToMany(targetEntity = ClassDay.class, fetch = FetchType.LAZY)
    private List<ClassDay> classDayList;
    //private List<Student> students;

    @Override
    public void validate() throws InvalidInputException {
        if (this.asignature == null) {
            throw new InvalidInputException(ErrorMessage.INVALID_ASSIGNATURE);
        }
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
}
