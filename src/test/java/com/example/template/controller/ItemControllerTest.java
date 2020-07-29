package com.example.template.controller;

import com.example.template.model.Item;
import com.example.template.service.ItemService;
import com.example.template.util.TestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @MockBean
    private ItemService itemService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldFindAllItemsReturnList() throws Exception {
        List<Item> testItems = Arrays.asList(new Item(1L, "Shoe"), new Item(2L, "Knife"));
        given(itemService.findItem(0L)).willReturn(TestUtils.createItems(testItems));

        mockMvc.perform(get("/item").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].itemId", is(1L)))
                .andExpect(jsonPath("$[0].itemName", is("Shoe")))
                .andExpect(jsonPath("$[1].itemId", is(2L)))
                .andExpect(jsonPath("$[1].itemName", is("knife")));
    }

    @Test
    void addition() {
        assertEquals(2, 2);
    }

}