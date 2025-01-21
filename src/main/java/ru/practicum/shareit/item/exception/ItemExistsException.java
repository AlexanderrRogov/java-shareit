package ru.practicum.shareit.item.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemExistsException extends RuntimeException {

    public ItemExistsException(String message) {
        super(message);
        log.info(message);
    }
}
