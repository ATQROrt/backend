package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private Asignature asignature;
    @OneToMany(targetEntity=Student.class, fetch= FetchType.EAGER)
    private Set<Student> studentsList;
    private Professor professor;
    @OneToMany(targetEntity=ClassDay.class, fetch= FetchType.EAGER)
    private Set<ClassDay> classDayList;

}
