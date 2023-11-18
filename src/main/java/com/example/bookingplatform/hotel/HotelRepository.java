package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.entity.Hotel;
import com.example.bookingplatform.hotel.room.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
