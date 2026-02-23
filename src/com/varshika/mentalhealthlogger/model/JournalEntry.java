package com.varshika.mentalhealthlogger.model;

import java.sql.Date;

public class JournalEntry {
    private int id;
    private int studentId;
    private String entryText;
    private String sentiment;  // Positive, Neutral, Negative
    private String emotion;    // Happy, Anxious, Stressed...
    private Date date;

    public JournalEntry() {}

    // Constructor with all fields
    public JournalEntry(int id, int studentId, String entryText, String sentiment, String emotion, Date date) {
        this.id = id;
        this.studentId = studentId;
        this.entryText = entryText;
        this.sentiment = sentiment;
        this.emotion = emotion;
        this.date = date;
    }

    // Constructor without ID (for inserting new entries)
    public JournalEntry(int studentId, String entryText, String sentiment, String emotion, Date date) {
        this.studentId = studentId;
        this.entryText = entryText;
        this.sentiment = sentiment;
        this.emotion = emotion;
        this.date = date;
    }

    // Getters
    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getEntryText() {
        return entryText;
    }

    public String getSentiment() {
        return sentiment;
    }

    public String getEmotion() {
        return emotion;
    }

    public Date getDate() {
        return date;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JournalEntry [id=" + id + ", studentId=" + studentId + ", entryText=" + entryText 
                + ", sentiment=" + sentiment + ", emotion=" + emotion + ", date=" + date + "]";
    }
}
