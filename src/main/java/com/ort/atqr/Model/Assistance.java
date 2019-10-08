package com.ort.atqr.Model;

import javax.persistence.*;

@Entity
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private AssistanceStatus status;
    @OneToOne
    private Student student;

    public AssistanceStatus getStatus() {
        return status;
    }

    public void setStatus(AssistanceStatus status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }
}
