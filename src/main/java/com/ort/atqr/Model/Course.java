package com.ort.atqr.Model;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Course {

    private String code;
    private Asignature asignature;
    private List<Student> studentsList;
    private Professor professor;
    private List<ClassDay> classDayList;

}
