package ru.job4j.tracker.sorting;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class AscendingSortByNameItem implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
