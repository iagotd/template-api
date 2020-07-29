package com.example.template.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude
public class ItemResource {
    private Long itemId;
    private String itemName;

    public ItemResource(Item item) {
        this.itemId = item.getItemId();
        this.itemName = item.getItemName();
    }

    @JsonCreator
    public ItemResource(@JsonProperty("itemId") Long itemId,
                        @JsonProperty("itemName") String itemName) {
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
