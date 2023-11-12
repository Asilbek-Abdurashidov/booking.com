package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HotelDtoMapper {
    private final ModelMapper modelMapper;

    public HotelResponseDto toResponseDto(Hotel hotel) {
        return modelMapper.map(hotel, HotelResponseDto.class);
    }

    public List<HotelResponseDto> toResponseDto(List<Hotel> hotels) {
        return hotels
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Hotel toEntity(HotelCreateDto hotelCreateDto) {
        return modelMapper.map(hotelCreateDto, Hotel.class);
    }
}