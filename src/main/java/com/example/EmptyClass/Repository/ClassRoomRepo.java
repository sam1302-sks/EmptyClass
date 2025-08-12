package com.example.EmptyClass.Repository;

import com.example.EmptyClass.Product.ClasRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClasRoom, Long> {


    List<ClasRoom> findByDayAndTimeSlot(String day, String timeSlot);

}