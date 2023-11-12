package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.entity.Hotel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.engine.jdbc.mutation.group.PreparedStatementGroup;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class HotelDtoMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public HotelResponseDto toResponseDto(Hotel hotel) {
        return modelMapper.map(hotel, HotelResponseDto.class);
    }
}