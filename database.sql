CREATE DATABASE mentalhealthdb;
USE mentalhealthdb;

-- Student Table
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    age INT
);

-- Mood Entry Table
CREATE TABLE mood_entry (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    mood VARCHAR(50),
    description TEXT,
    date DATE,
    FOREIGN KEY (student_id) REFERENCES student(id)
        ON DELETE CASCADE
);

-- Journal Entry Table
CREATE TABLE journal_entry (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    entryText TEXT,
    sentiment VARCHAR(50),
    emotion VARCHAR(50),
    date DATE,
    FOREIGN KEY (student_id) REFERENCES student(id)
        ON DELETE CASCADE
);
