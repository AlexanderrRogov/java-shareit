package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.model.Review;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public UserDto addUser(User user) {
        return userRepository.addUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteUser(userId);
    }

    @Override
    public UserDto updateUser(User user, Long userId) {
        return userRepository.updateUser(user, userId);
    }

    @Override
    public UserDto addReviewToUser(Review review, Long userId, Long sharedUser) {
        return userRepository.addReviewToUser(review, userId, sharedUser);
    }

    @Override
    public Set<UserDto> getUsers() {
        return userRepository.getUsers();
    }
}
