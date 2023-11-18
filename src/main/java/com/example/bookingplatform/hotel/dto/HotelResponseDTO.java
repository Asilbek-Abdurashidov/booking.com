package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.City;
import com.example.bookingplatform.hotel.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelResponseDTO {
    private Integer id;
    private String name;
    private City city;
    private List<Room> rooms;
    private String fileName;
}
