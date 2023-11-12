package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HotelCreateDto {
    private City city;
    private String name;
}
