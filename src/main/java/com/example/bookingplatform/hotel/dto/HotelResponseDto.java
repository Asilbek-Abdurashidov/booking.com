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
public class HotelResponseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private City city;
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;
}
