package com.example.template.controller.utils;

import com.example.template.model.Item;
import com.example.template.model.ItemResource;

import java.util.List;
import java.util.stream.Collectors;

public class ResourceConverter {
    private ResourceConverter() {
        throw new IllegalStateException("Utility class");
    }
    public static List<ItemResource> createItemResources(List<Item> items) {
        return items.stream().map(ItemResource::new).collect(Collectors.toList());
    }
}
