package com.example.bookingplatform.hotel.room;

import com.example.bookingplatform.hotel.room.dto.RoomCreateDto;
import com.example.bookingplatform.hotel.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDtoMapper {
    private final ModelMapper modelMapper;

    public Room toEntity(RoomCreateDto createDto) {
        return modelMapper.map(createDto, Room.class);
    }
}
