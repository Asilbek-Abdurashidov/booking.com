package com.example.bookingplatform.hotel.room.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomCreateDTO {
    private Integer number;
    private Integer roomCount;
    private Integer hotelId;
}
