package ru.practicum.shareit.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Review {

    private Long id;
    private Long authorId;
    @NotBlank
    private int rating;
    @NotBlank
    private String text;
    private LocalDateTime timeOfCreation;
    private Long itemId;
}
