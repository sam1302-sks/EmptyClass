package com.example.EmptyClass.Repository;

import com.example.EmptyClass.Product.ClasRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoomRepo extends JpaRepository {
    List<ClasRoom> findByDateAndTime(String date, String time);
}
