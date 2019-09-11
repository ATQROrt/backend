package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Asignature asignature;
    @OneToMany
    private List<Student> studentsList;
    private Professor professor;
    @OneToMany
    private List<ClassDay> classDayList;

}
