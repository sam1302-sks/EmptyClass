package com.example.EmptyClass.Controller;

import com.example.EmptyClass.Product.SearchRequest;
import com.example.EmptyClass.Service.ClassServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/classrooms")
public class ClassContro {

    @Autowired
    private ClassServ classServ;

    @PostMapping("/available")
    public List<String> findEmptyClassrooms(@RequestBody SearchRequest searchRequest) {
        String timeSlot = searchRequest.getStartTime() + "-" + searchRequest.getEndTime();
        return classServ.findEmptyRooms(searchRequest.getDate(), timeSlot);
    }
}