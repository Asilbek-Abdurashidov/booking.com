package com.example.bookingplatform.hotel.room;

import com.example.bookingplatform.hotel.room.dto.RoomCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;
    @PostMapping
    public String createRoom(@ModelAttribute RoomCreateDTO roomCreateDTO){
        roomService.create(roomCreateDTO);
        return "redirect:/hotel/%d/update".formatted(roomCreateDTO.getHotelId());
    }
}
