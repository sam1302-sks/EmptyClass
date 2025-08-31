package com.example.EmptyClass.Service;// In package com.example.EmptyClass.Service
import com.example.EmptyClass.Product.ClasRoom;
import com.example.EmptyClass.Repository.ClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClassServ {

    @Autowired
    private ClassRoomRepo classRoomRepository;

    public List<String> findEmptyRooms(String day, String timeSlot) {
        // Step 1: Get ALL possible classrooms directly from the database
        List<String> allRooms = classRoomRepository.findAllDistinctClassrooms();

        // Step 2: Find which classrooms are occupied at the given time
        List<ClasRoom> occupiedClassrooms = classRoomRepository.findByDayAndTimeSlot(day, timeSlot);

        // Step 3: Create a Set of occupied room numbers for efficient lookup
        Set<String> occupiedRoomNumbers = occupiedClassrooms.stream()
                .map(ClasRoom::getClassroom)
                .collect(Collectors.toSet());

        // Step 4: Filter the list of all rooms to find the ones that are not occupied
        return allRooms.stream()
                .filter(room -> !occupiedRoomNumbers.contains(room))
                .collect(Collectors.toList());
    }
}