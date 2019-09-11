package com.ort.atqr.Model;

import java.util.List;
import java.util.Set;

public class Course {
    private Long id;
    private String code;
    private Asignature asignature;
    private List<Student> studentsList;
    private Professor professor;
    private Set<ClassDay> classDayList;

}
