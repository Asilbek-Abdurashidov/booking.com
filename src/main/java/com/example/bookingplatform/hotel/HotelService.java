package com.example.bookingplatform.hotel;

import com.example.bookingplatform.hotel.dto.HotelCreateDTO;
import com.example.bookingplatform.hotel.dto.HotelDTOMapper;
import com.example.bookingplatform.hotel.dto.HotelResponseDTO;
import com.example.bookingplatform.hotel.entity.Hotel;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelDTOMapper hotelDTOMapper;

    public List<HotelResponseDTO> getAllHotels() {
        List<Hotel> all = hotelRepository.findAll();
        return hotelDTOMapper.toResponseDTO(all);
    }

    public void create(HotelCreateDTO hotelCreateDTO) throws IOException {
        MultipartFile picture = hotelCreateDTO.getPicture();

        String fileName = UUID.randomUUID() + picture.getOriginalFilename();

        byte[] bytes = picture.getBytes();
        String base64Img = Base64.getEncoder().encodeToString(bytes);

        Hotel entity = hotelDTOMapper.toEntity(hotelCreateDTO);
        entity.setFileName(fileName);
        entity.setContentType(picture.getContentType());
        entity.setImg(base64Img);
        hotelRepository.save(entity);
    }

    public HotelResponseDTO getById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        return hotelDTOMapper.toResponseDTO(hotel);
    }

    public ResponseEntity<Resource> downloadFile(Integer id, HttpServletResponse response) throws IOException {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        byte[] decode = Base64.getDecoder().decode(hotel.getImg().getBytes());
        ByteArrayResource byteArrayResource = new ByteArrayResource(decode);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(hotel.getContentType()))
                .body(byteArrayResource);
    }
//    internalization
//    i18n
}
