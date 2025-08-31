package com.example.EmptyClass.Controller;

import com.example.EmptyClass.Product.SearchRequest;
import com.example.EmptyClass.Service.ClassServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/classrooms")
@CrossOrigin(origins = "*") // Allow all origins for testing
public class ClassContro {

    @Autowired
    private ClassServ classServ;


    private String formatTime(String time) {
        String[] parts = time.split(":");
        return String.format("%02d:%s", Integer.parseInt(parts[0]), parts[1]);
    }

    @PostMapping("/available")
    public List<String> findEmptyClassrooms(@RequestBody SearchRequest searchRequest) {

        String dayName = LocalDate.parse(searchRequest.getDate())
                .getDayOfWeek()
                .getDisplayName(TextStyle.FULL, Locale.ENGLISH);


        String timeSlot = formatTime(searchRequest.getStartTime()) + "-" + formatTime(searchRequest.getEndTime());


        System.out.println("Searching for Day: " + dayName + " | Time Slot: " + timeSlot);

        return classServ.findEmptyRooms(dayName, timeSlot);
    }
}
