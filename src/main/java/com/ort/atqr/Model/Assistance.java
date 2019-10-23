package com.ort.atqr.Model;

import javax.persistence.*;

@Entity
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Student student;
    @Enumerated
    @Column(columnDefinition = "int default 1")
    private AssistanceStatus assistanceStatus;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public AssistanceStatus getAssistanceStatus() {
        return assistanceStatus;
    }

    public void setAssistanceStatus(AssistanceStatus assistanceStatus) {
        this.assistanceStatus = assistanceStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
