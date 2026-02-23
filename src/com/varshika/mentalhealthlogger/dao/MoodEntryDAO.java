package com.varshika.mentalhealthlogger.dao;

import java.sql.*;
import java.util.*;
import com.varshika.mentalhealthlogger.model.MoodEntry;
import com.varshika.mentalhealthlogger.util.DBConnection;

public class MoodEntryDAO {

    // Add a mood entry
    public boolean addMoodEntry(MoodEntry entry) {
        String query = "INSERT INTO mood_entry(student_id, mood, description, date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, entry.getStudentId());
            ps.setString(2, entry.getMood());
            ps.setString(3, entry.getDescription());
            ps.setDate(4, entry.getDate());

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Get all mood entries for a student
    public List<MoodEntry> getMoodEntriesByStudent(int studentId) {
        List<MoodEntry> moods = new ArrayList<>();
        String query = "SELECT * FROM mood_entry WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, studentId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                MoodEntry m = new MoodEntry(
                        rs.getInt("id"),
                        rs.getInt("student_id"),
                        rs.getString("mood"),
                        rs.getString("description"),
                        rs.getDate("date")
                );
                moods.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return moods;
    }
}
