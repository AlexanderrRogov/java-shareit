package ru.practicum.shareit.booking.service;

import ru.practicum.shareit.booking.dto.BookingDto;
import ru.practicum.shareit.booking.model.Booking;

import java.util.List;

public interface BookingService {

    BookingDto addBooking(Booking booking, Long userId);

    BookingDto getBookingById(Long id);

    BookingDto updateBooking(Booking booking, Long userId, Long bookingId);

    List<BookingDto> getBookings();

    BookingDto deleteBooking(Long bookingId, Long userId);

    BookingDto confirmationBooking(Long userId, Long bookingId);
}
