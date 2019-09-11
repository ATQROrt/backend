package com.ort.atqr.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Asignature {
    @Id
    private String code;
    private String name;
}
