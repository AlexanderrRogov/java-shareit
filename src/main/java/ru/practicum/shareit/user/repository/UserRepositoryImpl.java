package ru.practicum.shareit.user.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.exception.EmailDuplicateException;
import ru.practicum.shareit.user.exception.UserExistsException;
import ru.practicum.shareit.user.exception.UserNotFoundException;
import ru.practicum.shareit.user.model.Review;
import ru.practicum.shareit.user.model.User;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Component
public class UserRepositoryImpl implements UserRepository {

    private static Long userId = 1L;
    private final Set<User> users = new HashSet<>();

    @Override
    public UserDto getUserById(Long id) {
        User user = findUser(id);
        log.info("Found user: " + user);

        return createUserDto(user);
    }

    @Override
    public Set<UserDto> getUsers() {
        Set<UserDto> usersDto = new HashSet<>();
        users.forEach(user -> usersDto.add(createUserDto(user)));

        return usersDto;
    }

    @Override
    public UserDto addUser(User user) {
        checkOnExist(user);
        checkDuplicateEmail(user, user.getId());
        user.setId(userId++);
        users.add(user);
        log.info("User with id: " + user.getId() + " saved");

        return createUserDto(user);
    }



    @Override
    public void deleteUser(Long userId) {
        User user = findUser(userId);
        users.remove(user);
        log.info("User with id: " + userId + " removed");
    }

    @Override
    public UserDto addReviewToUser(Review review, Long userId, Long sharedUser) {
        User user = findUser(userId);
        user.getReviews().add(review);
        log.info("Review with id: " + review.getId() + "added to User with id: " + userId);

        return createUserDto(user);
    }

    @Override
    public UserDto updateUser(User user, Long userId) {
        User currentUser = findUser(userId);

        if (user.getName() != null) {
            currentUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            checkDuplicateEmail(user, userId);
            currentUser.setEmail(user.getEmail());
        }
        return createUserDto(currentUser);
    }

    private UserDto createUserDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail());
    }

    private void checkOnExist(User user) {
        if (users.stream()
                .anyMatch(currentUser -> currentUser.getId().equals(user.getId()))) {
            throw new UserExistsException("User with id: " + user.getId() + " already exists");
        }
    }

    private void checkDuplicateEmail(User user, Long userId) {
        users.stream()
                .filter(currentUser -> currentUser.getEmail().equals(user.getEmail()))
                .forEach(currentUser -> {
                    if (!currentUser.getId().equals(userId)) {
                        throw new EmailDuplicateException("User with this email already exists");
                    }
                });
    }

    private User findUser(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }
}
