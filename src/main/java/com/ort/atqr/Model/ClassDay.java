package com.ort.atqr.Model;

import com.ort.atqr.Exception.InvalidInputException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class ClassDay{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity = Assistance.class, fetch = FetchType.LAZY)
    private List<Assistance> assistanceList;
    private LocalDate date;
    private Boolean cancelled;

    public ClassDay(){
        this.assistanceList = new ArrayList<>();
        this.date = LocalDate.now();
        this.cancelled = false;
    }

    public void addAssistance(Assistance assistance){
        assistanceList.add(assistance);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Assistance> getAssistanceList() {
        return assistanceList;
    }

    public void setAssistanceList(List<Assistance> assistanceList) {
        this.assistanceList = assistanceList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }

}
