package com.example.template.controller;

import com.example.template.model.ItemResource;
import com.example.template.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.template.controller.utils.ResourceConverter.createItemResources;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item")
    public ResponseEntity<List<ItemResource>> getItem(@RequestParam(value = "itemId", required = false, defaultValue = "0") Long itemId) {
        return new ResponseEntity<>(createItemResources(itemService.findItem(itemId)), HttpStatus.OK);
    }

    @PostMapping("/item")
    public ResponseEntity<Boolean> postItem (@RequestBody ItemResource itemResource) {
        return new ResponseEntity<>(itemService.insertItem(itemResource), HttpStatus.OK);
    }

    @DeleteMapping("/item")
    public ResponseEntity<Boolean> deleteItem(@RequestParam(value = "itemId", required = true) Long itemId) {
        return new ResponseEntity<>(itemService.deleteItem(itemId), HttpStatus.OK);
    }
}
