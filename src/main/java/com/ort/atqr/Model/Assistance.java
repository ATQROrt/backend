package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Assistance {
    @Id
    private Long id;
    private AssistanceStatus status;
    @OneToOne
    private Student student;

}
