package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int counter = 0;
        for (int i = 0; i < size; i++) {
            Item item = items[i];
            if (item.getName().equals(key)) {
                rsl[i] = item;
            }
            counter++;
        }
        return Arrays.copyOf(rsl, counter);
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public boolean replace(int id, Item item) {
        for (int i = 0; i < size; i++) {
            if (indexOf(id) == indexOf(items[i].getId())) {
                item.setId(items[i].getId());
                this.items[i] = item;
                break;
            }
        }
        return findById(id).equals(item);
    }

    public boolean delete(int id) {
        for (int i = 0; i < size; i++) {
            if (indexOf(id) == indexOf(items[i].getId())) {
                items[i] = null;
                System.arraycopy(items, i + 1, items, i, size - i);
                items[size - 1] = null;
                size--;
            }
        }
        return findById(id + 1) == null;
    }
}