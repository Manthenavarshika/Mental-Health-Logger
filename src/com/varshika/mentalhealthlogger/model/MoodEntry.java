package com.varshika.mentalhealthlogger.model;

import java.sql.Date;

public class MoodEntry {
    private int id;
    private int studentId;
    private String mood;
    private String description;
    private Date date;

    public MoodEntry() {}

    public MoodEntry(int id, int studentId, String mood, String description, Date date) {
        this.id = id;
        this.studentId = studentId;
        this.mood = mood;
        this.description = description;
        this.date = date;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public String getMood() { return mood; }
    public void setMood(String mood) { this.mood = mood; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    @Override
    public String toString() {
        return "MoodEntry [id=" + id + ", studentId=" + studentId + ", mood=" + mood + ", description=" + description + ", date=" + date + "]";
    }
}
