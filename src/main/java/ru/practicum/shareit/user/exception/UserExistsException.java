package ru.practicum.shareit.user.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserExistsException extends RuntimeException {

    public UserExistsException(String message) {
        super(message);
        log.info(message);
    }
}
