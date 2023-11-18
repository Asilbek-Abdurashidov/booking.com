package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelCreateDto;
import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import com.example.bookingplatform.hotel.room.entity.Room;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public String createHotel(@ModelAttribute HotelCreateDto createDto) {
        hotelService.create(createDto);
        return "index";
    }

    @GetMapping
    public String getAllHotels(Model model) {
        List<HotelResponseDto> responseDtos = hotelService.getAllHotels();
        model.addAttribute("hotels", responseDtos);
        return "index";
    }

    @GetMapping("/create")
    public String getCreatPage() {
        return "hotel/create";
    }

    @GetMapping("/{id}/rooms")
    public String getHotelRooms(@PathVariable Integer id,
                                @RequestParam Integer roomCount,
                                @RequestParam LocalDateTime startDate,
                                @RequestParam LocalDateTime endDate,
                                Model model) {
        List<Room> rooms = hotelService.getRooms(id, roomCount, startDate, endDate);
        model.addAttribute("rooms", rooms);
        return "room/rooms";
    }

    @GetMapping("/{id}/update")
    public String getEditHotel(@PathVariable Integer id, Model model) {
        HotelResponseDto hotelResponseDto = hotelService.getById(id);
        model.addAttribute("hotel", hotelResponseDto);

        return "hotel/update";
    }
}
