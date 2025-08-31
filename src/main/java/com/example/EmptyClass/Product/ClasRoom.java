package com.example.EmptyClass.Product;// In package com.example.EmptyClass.Product
import jakarta.persistence.*;

@Entity
@Table(name = "timetable") // Your original table name
public class ClasRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming you have an auto-incrementing ID
    private Long id;

    // Corrected column mappings to match your database
    @Column(name = "classroom")
    private String classroom;

    @Column(name = "day")
    private String day;

    @Column(name = "time_slot") // Correctly maps to "Time Slot" with a space
    private String timeSlot;

    @Column(name = "class") // Correctly maps to "Class"
    private String classInfo;

    // --- Getters and Setters remain the same ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClassroom() { return classroom; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    public String getDay() { return day; }
    public void setDay(String day) { this.day = day; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public String getClassInfo() { return classInfo; }
    public void setClassInfo(String classInfo) { this.classInfo = classInfo; }
}