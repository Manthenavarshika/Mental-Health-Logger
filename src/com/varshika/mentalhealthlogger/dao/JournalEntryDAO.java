package com.varshika.mentalhealthlogger.dao;

import java.sql.*;
import java.util.*;
import com.varshika.mentalhealthlogger.model.JournalEntry;
import com.varshika.mentalhealthlogger.util.DBConnection;

public class JournalEntryDAO {

    public boolean addJournalEntry(JournalEntry entry) {
        String query = "INSERT INTO journal_entry(student_id, entryText, sentiment, emotion, date) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, entry.getStudentId());
            ps.setString(2, entry.getEntryText());
            ps.setString(3, entry.getSentiment());
            ps.setString(4, entry.getEmotion());
            ps.setDate(5, entry.getDate());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<JournalEntry> getEntriesByStudent(int studentId) {
        List<JournalEntry> list = new ArrayList<>();
        String query = "SELECT * FROM journal_entry WHERE student_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new JournalEntry(
                    rs.getInt("id"),
                    rs.getInt("student_id"),
                    rs.getString("entryText"),
                    rs.getString("sentiment"),
                    rs.getString("emotion"),
                    rs.getDate("date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
