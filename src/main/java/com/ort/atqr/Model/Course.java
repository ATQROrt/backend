package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Asignature asignature;
    private List<Student> studentsList;
    private Professor professor;
    private List<ClassDay> classDayList;

}
