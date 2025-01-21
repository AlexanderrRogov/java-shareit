package ru.practicum.shareit.user.repository;

import ru.practicum.shareit.user.model.Review;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

import java.util.Set;

public interface UserRepository {

    UserDto getUserById(Long id);

    UserDto updateUser(User user, Long userId);

    UserDto addUser(User user);

    UserDto addReviewToUser(Review review, Long userId, Long sharedUser);

    Set<UserDto> getUsers();

    void deleteUser(Long userId);
}
