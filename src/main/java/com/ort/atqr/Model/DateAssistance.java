package com.ort.atqr.Model;

import java.time.LocalDate;

public class DateAssistance {
    private LocalDate date;
    private AssistanceStatus assistanceStatus;
    private Boolean cancelled;

    public DateAssistance(LocalDate date, AssistanceStatus assistanceStatus, Boolean cancelled) {
        this.date = date;
        this.assistanceStatus = assistanceStatus;
        this.cancelled = cancelled;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public AssistanceStatus getAssistanceStatus() {
        return assistanceStatus;
    }

    public void setAssistanceStatus(AssistanceStatus assistance) {
        this.assistanceStatus = assistance;
    }

    public Boolean getCancelled() {
        return cancelled;
    }

    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
    }
}
