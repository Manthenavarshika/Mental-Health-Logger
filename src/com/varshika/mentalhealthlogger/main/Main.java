package com.varshika.mentalhealthlogger.main;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.varshika.mentalhealthlogger.dao.StudentDAO;
import com.varshika.mentalhealthlogger.dao.MoodEntryDAO;
import com.varshika.mentalhealthlogger.dao.JournalEntryDAO;
import com.varshika.mentalhealthlogger.model.Student;
import com.varshika.mentalhealthlogger.model.MoodEntry;
import com.varshika.mentalhealthlogger.model.JournalEntry;
import com.varshika.mentalhealthlogger.util.NLPHelper;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        MoodEntryDAO moodDAO = new MoodEntryDAO();
        JournalEntryDAO journalDAO = new JournalEntryDAO();

        while (true) {
            System.out.println("\n=== Mental Health Logger ===");
            System.out.println("1. Add Student");
            System.out.println("2. Add Mood Entry");
            System.out.println("3. Add Journal Entry (AI Analysis)");
            System.out.println("4. View All Students");
            System.out.println("5. View Mood Entries of a Student");
            System.out.println("6. View Journal Entries of a Student");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(0, name, email, age);
                    if (studentDAO.addStudent(student)) {
                        System.out.println("✅ Student added successfully!");
                    } else {
                        System.out.println("❌ Failed to add student!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Mood: ");
                    String mood = sc.nextLine();
                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String dateStr = sc.nextLine();

                    MoodEntry entry = new MoodEntry(0, sid, mood, desc, Date.valueOf(dateStr));
                    if (moodDAO.addMoodEntry(entry)) {
                        System.out.println("✅ Mood entry added!");
                    } else {
                        System.out.println("❌ Failed to add mood entry!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int jid = sc.nextInt();
                    sc.nextLine();
                    System.out.println("I felt sad today because of exams"+"I am happy and excited");
                    System.out.print("Enter Journal Text: ");
                    String text = sc.nextLine();
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    String jDateStr = sc.nextLine();

                    // AI Analysis
                    String sentiment = NLPHelper.analyzeSentiment(text);
                    String emotion = NLPHelper.detectEmotion(text);

                    JournalEntry journal = new JournalEntry(0, jid, text, sentiment, emotion, Date.valueOf(jDateStr));
                    if (journalDAO.addJournalEntry(journal)) {
                        System.out.println("✅ Journal entry added!");
                        System.out.println("Sentiment: " + sentiment + ", Emotion: " + emotion);
                    } else {
                        System.out.println("❌ Failed to add journal entry!");
                    }
                    break;

                case 4:
                    List<Student> students = studentDAO.getAllStudents();
                    System.out.println("\n--- Students ---");
                    for (Student s : students) System.out.println(s);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    int stId = sc.nextInt();
                    sc.nextLine();
                    List<MoodEntry> moods = moodDAO.getMoodEntriesByStudent(stId);
                    System.out.println("\n--- Mood Entries ---");
                    for (MoodEntry m : moods) System.out.println(m);
                    break;

                case 6:
                    System.out.print("Enter Student ID: ");
                    int jStId = sc.nextInt();
                    sc.nextLine();
                    List<JournalEntry> journals = journalDAO.getEntriesByStudent(jStId);
                    System.out.println("\n--- Journal Entries ---");
                    for (JournalEntry j : journals) {
                        System.out.println(j);
                    }
                    break;

                case 7:
                    System.out.println("Exiting... Bye 👋");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
