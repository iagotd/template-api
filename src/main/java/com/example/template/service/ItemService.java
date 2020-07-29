package com.example.template.service;

import com.example.template.model.Item;
import com.example.template.model.ItemResource;
import com.example.template.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findItem(Long itemId) {
        try {
            if (itemId == 0) {
                return itemRepository.findAll();
            } else {
                return (List<Item>) itemRepository.findAllByItemId(itemId);
            }
        } catch (InvalidDataAccessApiUsageException | IllegalArgumentException | NullPointerException e) {
            return Collections.emptyList();
        }
    }

    public Boolean insertItem(ItemResource itemResource) {
        return itemRepository.createItem(itemResource);
    }

    public Boolean deleteItem(Long itemId) {
        try {
            itemRepository.deleteByItemId(itemId);
            return true;
        } catch (InvalidDataAccessApiUsageException | IllegalArgumentException | NullPointerException e) {
            return false;
        }

    }
}