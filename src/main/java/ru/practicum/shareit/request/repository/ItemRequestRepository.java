package ru.practicum.shareit.request.repository;

import ru.practicum.shareit.request.dto.ItemRequestDto;
import ru.practicum.shareit.request.model.ItemRequest;

import java.util.Set;

public interface ItemRequestRepository {

    ItemRequestDto updateItemRequest(ItemRequest itemRequest, Long userId, Long itemRequestId);

    ItemRequestDto addItemRequest(ItemRequest itemRequest, Long userId);

    ItemRequestDto getItemRequestById(Long id);

    Set<ItemRequestDto> getItemRequests();

    ItemRequestDto deleteItemRequest(ItemRequest itemRequest, Long userId);
}
