package com.example.bookingplatform.book;

import com.example.bookingplatform.book.dto.BookCreateDto;
import com.example.bookingplatform.book.entity.Book;
import com.example.bookingplatform.hotel.room.RoomRepository;
import com.example.bookingplatform.hotel.room.entity.Room;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final RoomRepository roomRepository;

    public void create(BookCreateDto createDto) {
        Room room = roomRepository.findById(createDto.getRoomId()).orElseThrow();

        Book book = new Book(null, room, createDto.getStartDate(), createDto.getEndDate());

        bookRepository.save(book);
    }
}
