package ru.practicum.shareit.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.practicum.shareit.item.model.Item;

import java.util.List;


public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i " +
            "from Item as i " +
            "where i.available = true and " +
            "(lower(i.name) like lower(concat('%', ?1, '%') ) or " +
            "lower(i.description) like lower(concat('%', ?1, '%') ))")
    List<Item> search(String text);

    List<Item> findAllByOwnerId(Long ownerId);

    @Modifying
    @Query("update Item as i set i.name = ?2," +
            " i.description = ?3," +
            " i.available = ?4" +
            " where i.id = ?1")
    void update(Long id, String itemName, String itemDescription, Boolean Available);
}