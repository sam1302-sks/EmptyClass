package com.example.EmptyClass.Service;

import com.example.EmptyClass.Product.ClasRoom;
import com.example.EmptyClass.Repository.ClassRoomRepo;
import com.example.EmptyClass.Repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassServ {

    @Autowired
    private ClassRoomRepo classRoomRepository;

    public List<Integer> findEmptyRooms(String date, String time) {

        List<Integer> allRooms = List.of(1001, 1002, 1003, 4001, 4002, 4003);


        List<ClasRoom> occupiedRoomsList = classRoomRepository.findByDateAndTime(date, time);


        Set<Integer> occupiedRooms = occupiedRoomsList.stream()
                .map(ClasRoom::getRoomNo)
                .collect(Collectors.toSet());


        return allRooms.stream()
                .filter(room -> !occupiedRooms.contains(room))
                .collect(Collectors.toList());
    }
}