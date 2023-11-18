package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelCreateDTO;
import com.example.bookingplatform.hotel.dto.HotelResponseDTO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/hotel")
@RequiredArgsConstructor
public class HotelController {
    private final HotelService hotelService;

    @PostMapping
    public String createHotel(@ModelAttribute HotelCreateDTO hotelCreateDTO) throws IOException {
        hotelService.create(hotelCreateDTO);
        return "index";
    }

    @GetMapping
    public String getAllHotel(Model model) {
        List<HotelResponseDTO> hotelResponseDTOS = hotelService.getAllHotels();
        model.addAttribute("hotels", hotelResponseDTOS);
        return "index";
    }

    @GetMapping("/create")
    public String getCreatePage() {
        return "hotel/create";
    }

    @GetMapping("/{id}/rooms")
    public String getHotelRooms(@PathVariable Integer id) {

        return "index";
    }

    @GetMapping("/{id}/update")
    public String getEditHotel(@PathVariable Integer id, Model model) {
        HotelResponseDTO hotelResponseDTO = hotelService.getById(id);
        model.addAttribute("hotel", hotelResponseDTO);
        return "hotel/update";
    }

    @GetMapping(value = "/download/{id}")
    public ResponseEntity<Resource> downloadPicture(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        return hotelService.downloadFile(id, response);
    }


}
