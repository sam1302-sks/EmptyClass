package com.example.EmptyClass.Controller;

import com.example.EmptyClass.Product.ClasRoom;
import com.example.EmptyClass.Service.ClassServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassContro {
    @Autowired
    private ClassServ classServ;
    @PostMapping("/")
    public List<Integer> find(@RequestParam String date,@RequestParam String time){
 return classServ.findEmptyRooms(date,time);


    }
}
