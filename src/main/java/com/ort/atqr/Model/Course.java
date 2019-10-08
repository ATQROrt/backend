package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Course {
    @Id
    private String code;
    @OneToOne
    private Asignature asignature;
    @OneToMany(targetEntity = Student.class, fetch = FetchType.EAGER)
    private Set<Student> studentsList;
    @OneToOne
    private Professor professor;
    @OneToMany(targetEntity = ClassDay.class, fetch = FetchType.EAGER)
    private List<ClassDay> classDayList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Asignature getAsignature() {
        return asignature;
    }

    public void setAsignature(Asignature asignature) {
        this.asignature = asignature;
    }

    public Set<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(Set<Student> studentsList) {
        this.studentsList = studentsList;
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

    public Integer assistancePercentage(){
        int allClassDays = classDayList.size();
        if(allClassDays < 1){
            throw new IllegalArgumentException("The classday list can't be empty. ");
        }

        int presentClassDays = 0;
        for(int i = 0; i<allClassDays; i++){
            if(classDayList.get(i).getAssistance().getStatus() == AssistanceStatus.PRESENT){
                presentClassDays++;
            }
        }
        return (allClassDays*presentClassDays)/100;
    }

}
