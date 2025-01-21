package ru.practicum.shareit.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.shareit.item.exception.NotOwnerException;
import ru.practicum.shareit.user.exception.EmailDuplicateException;
import ru.practicum.shareit.user.exception.UserNotFoundException;

@RestControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApplicationError handleDuplicateEmailException(final EmailDuplicateException e) {
        return new ApplicationError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApplicationError handleUserNotFoundException(final UserNotFoundException e) {
        return new ApplicationError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApplicationError handleRuntimeException(final RuntimeException e) {
        return new ApplicationError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApplicationError handleNotOwnerException(final NotOwnerException e) {
        return new ApplicationError(e.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApplicationError handleNotValidException(final MethodArgumentNotValidException e) {
        return new ApplicationError(e.getMessage());
    }
}
