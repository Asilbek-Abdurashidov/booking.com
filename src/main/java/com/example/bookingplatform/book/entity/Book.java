package com.example.bookingplatform.book.entity;

import com.example.bookingplatform.hotel.room.RoomRepository;
import com.example.bookingplatform.hotel.room.entity.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @ManyToOne
    private Room room;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
