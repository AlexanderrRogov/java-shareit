package ru.practicum.shareit.request.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemRequestExistsException extends RuntimeException {

    public ItemRequestExistsException(String message) {
        super(message);
        log.info(message);
    }
}
