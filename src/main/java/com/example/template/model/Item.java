package com.example.template.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "item")
public class Item {

    private Long itemId;
    private String itemName;

    public Item() {
    }

    public Item(Long itemId, String itemName) {
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "item_id", unique = true, nullable = false)
    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Column(name = "item_name", nullable = false, length = 10)
    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
