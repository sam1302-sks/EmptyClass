package com.example.EmptyClass.Product;

// In package com.example.EmptyClass.Product
public class SearchRequest {
    private String date;
    private String startTime;
    private String endTime;

    // Add Getters and Setters for all three fields
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }
    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }
}