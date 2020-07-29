package com.example.template.util;

import com.example.template.model.Item;

import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static List<Item> createItems(List<Item> testItems) {

        switch (testItems.size()) {
            case 1:
                return Arrays.asList(testItems.get(0));
            case 2:
                return Arrays.asList(testItems.get(0), testItems.get(1));
            default:
                return Arrays.asList();
        }
    }
}
