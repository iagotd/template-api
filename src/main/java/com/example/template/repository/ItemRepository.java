package com.example.template.repository;

import com.example.template.model.Item;
import com.example.template.model.ItemResource;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAll();
    Item findAllByItemId(Long itemId);

    @Modifying
    @Transactional
    @Query(value = "delete from item where item.item_id = ?1", nativeQuery = true)
    void deleteByItemId(Long itemId);

    default boolean createItem(ItemResource itemResource) {
        Item item = new Item(itemResource.getItemId(), itemResource.getItemName());
        try {
            save(item);
            return true;
        } catch (InvalidDataAccessApiUsageException | IllegalArgumentException | NullPointerException e) {
            return false;
        }
    }
}
