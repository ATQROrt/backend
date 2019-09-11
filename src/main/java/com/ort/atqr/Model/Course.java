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
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> studentsList;
    private Professor professor;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ClassDay> classDayList;

}
