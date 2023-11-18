package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.entity.Hotel;
import com.example.bookingplatform.hotel.room.RoomRepository;
import com.example.bookingplatform.hotel.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final HotelDtoMapper hotelDtoMapper;

    public List<HotelResponseDto> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return hotelDtoMapper.toResponseDto(all);
    }

    public void create(HotelCreateDto createDto) {
        Hotel entity = hotelDtoMapper.toEntity(createDto);
        hotelRepository.save(entity);
    }

    public HotelResponseDto getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        return hotelDtoMapper.toResponseDto(hotel);
    }

    public List<Room> getRooms(Integer id, Integer roomCount, LocalDateTime startDate, LocalDateTime endDate) {
        List<Room> availableRooms = roomRepository.findAvailableRooms(id, roomCount, startDate, endDate);
        return availableRooms;
    }
}
