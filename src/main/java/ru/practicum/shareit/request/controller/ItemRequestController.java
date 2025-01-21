package ru.practicum.shareit.request.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.request.dto.ItemRequestDto;
import ru.practicum.shareit.request.model.ItemRequest;
import ru.practicum.shareit.request.service.ItemRequestService;

import jakarta.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(path = "/requests")
@RequiredArgsConstructor
public class ItemRequestController {

    private final ItemRequestService itemRequestService;

    @PostMapping
    public ItemRequestDto addItemRequest(@Valid @RequestBody ItemRequest itemRequest,
                                         @RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemRequestService.addItemRequest(itemRequest, userId);
    }

    @GetMapping
    public Set<ItemRequestDto> getItemRequests() {
        return itemRequestService.getItemRequests();
    }

    @DeleteMapping
    public ItemRequestDto deleteItemRequest(@RequestBody ItemRequest itemRequest,
                                            @RequestHeader("X-Sharer-User-Id") Long userId) {
        return itemRequestService.deleteItemRequest(itemRequest, userId);
    }

    @PatchMapping("/{itemRequestId}")
    public ItemRequestDto updateItemRequest(@RequestBody ItemRequest itemRequest,
                                            @RequestHeader("X-Sharer-User-Id") Long userId,
                                            @PathVariable Long itemRequestId) {
        return itemRequestService.updateItemRequest(itemRequest, userId, itemRequestId);
    }

    @GetMapping("/{itemRequestId}")
    public ItemRequestDto getItemRequest(@PathVariable Long id) {
        return itemRequestService.getItemRequestById(id);
    }

}
