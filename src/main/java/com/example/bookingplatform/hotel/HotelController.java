package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @GetMapping
    public String getAllHotels(Model model) {
        List<HotelResponseDto> responseDtos = hotelService.getAllHotels();
        model.addAttribute("hotels", responseDtos);
        return "index";
    }
}
