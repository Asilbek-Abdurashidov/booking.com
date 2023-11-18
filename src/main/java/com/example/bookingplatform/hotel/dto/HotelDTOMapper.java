package com.example.bookingplatform.hotel.dto;

import com.example.bookingplatform.hotel.HotelService;
import com.example.bookingplatform.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelDTOMapper {
    private final ModelMapper modelMapper;

    public HotelResponseDTO toResponseDTO(Hotel hotel) {
        return modelMapper.map(hotel, HotelResponseDTO.class);
    }

    public List<HotelResponseDTO> toResponseDTO(List<Hotel> hotels) {
        return hotels.stream().map(this::toResponseDTO).toList();
    }
    public Hotel toEntity(HotelCreateDTO hotelCreateDTO){
        return modelMapper.map(hotelCreateDTO, Hotel.class);
    }
}
