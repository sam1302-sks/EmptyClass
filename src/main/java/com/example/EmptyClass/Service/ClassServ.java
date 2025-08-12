package com.example.EmptyClass.Service;

import com.example.EmptyClass.Product.ClasRoom;
import com.example.EmptyClass.Repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassServ {

    @Autowired
    private ClassRoomRepo classRoomRepository;

    public List<String> findEmptyRooms(String day, String timeSlot) {

        List<String> allRooms = new ArrayList<>();


        for (int i = 3; i <= 7; i++) {
            allRooms.add("400" + i);
        }


        for (int i = 3; i <= 7; i++) {
            allRooms.add("410" + i);
        }


        for (int i = 3; i <= 7; i++) {
            allRooms.add("420" + i);
        }


        for (int i = 2; i <= 7; i++) {
            allRooms.add("430" + i);
        }


        List<ClasRoom> occupiedClassrooms = classRoomRepository.findByDayAndTimeSlot(day, timeSlot);


        Set<String> occupiedRoomNumbers = occupiedClassrooms.stream()
                .map(ClasRoom::getClassroom)
                .collect(Collectors.toSet());
        return allRooms.stream()
                .filter(room -> !occupiedRoomNumbers.contains(room))
                .collect(Collectors.toList());
    }
}