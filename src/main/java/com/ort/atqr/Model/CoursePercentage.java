package com.ort.atqr.Model;

public class CoursePercentage {

    private Course course;
    private int percentage;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public CoursePercentage(Course course, int percentage) {
        this.course = course;
        this.percentage = percentage;
    }
}
