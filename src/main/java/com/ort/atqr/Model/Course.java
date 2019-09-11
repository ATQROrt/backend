package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Asignature asignature;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> studentsList;
    @OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Professor professor;
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ClassDay> classDayList;

}
