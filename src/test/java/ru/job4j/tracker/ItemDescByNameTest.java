package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    void whenItemDescByNameOder() {
        Item one = new Item("1");
        Item two = new Item("2");
        Item three = new Item("3");
        List<Item> items = Arrays.asList(one, three, two);
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(three, two, one);
        assertThat(items).isEqualTo(expected);
    }
}