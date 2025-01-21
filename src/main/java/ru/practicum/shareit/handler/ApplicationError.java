package ru.practicum.shareit.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationError {
    private String message;
}
