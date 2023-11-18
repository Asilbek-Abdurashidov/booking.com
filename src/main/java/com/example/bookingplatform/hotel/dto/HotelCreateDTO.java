package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.address.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelCreateDTO {
    private City city;
    private String name;
    private MultipartFile picture;
}
