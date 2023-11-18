package com.example.bookingplatform.hotel.room;

import com.example.bookingplatform.hotel.room.dto.RoomCreateDTO;
import com.example.bookingplatform.hotel.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoomDTOMapper {
    private final ModelMapper modelMapper;
    public Room toEntity(RoomCreateDTO createDTO){
        return modelMapper.map(createDTO, Room.class);
    }
}
