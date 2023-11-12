package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.entity.Hotel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelDtoMapper hotelDtoMapper;

    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return all
                .stream()
                .map(hotelDtoMapper::toResponseDto)
                .toList();
    }
}
