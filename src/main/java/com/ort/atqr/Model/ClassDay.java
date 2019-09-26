package com.ort.atqr.Model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class ClassDay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(targetEntity = Assistance.class, fetch = FetchType.EAGER)
    private Set<Assistance> assistance;
    private Date date;
    private Boolean cancelled;

    public Long getId() {
        return id;
    }

    public Set<Assistance> getAssistance() {
        return assistance;
    }

    public void setAssistance(Set<Assistance> assistance) {
        this.assistance = assistance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
