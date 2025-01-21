package ru.practicum.shareit.user.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.List;

@Data
@EqualsAndHashCode(of = {"id"})
public class User {

    private Long id;
    @NotBlank
    private String name;
    @Email(message = "Wrong email")
    @NotBlank
    private String email;
    private List<Review> reviews;
}
