package com.example.EmptyClass.Repository;// In package com.example.EmptyClass.Repository
import com.example.EmptyClass.Product.ClasRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRoomRepo extends JpaRepository<ClasRoom, Long> {

    // Finds occupied rooms by day and time slot
    List<ClasRoom> findByDayAndTimeSlot(String day, String timeSlot);

    // New Method: Gets a list of all unique classroom numbers from the DB
    @Query("SELECT DISTINCT c.classroom FROM ClasRoom c ORDER BY c.classroom ASC")
    List<String> findAllDistinctClassrooms();
}