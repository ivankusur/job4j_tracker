package oop;

import java.util.Arrays;

public class Machine {
    private final int[] coins = {10, 5, 2, 1};

    public int[] change(int money, int price) {
        int[] rsl = new int[100];
        int size = 0;
        int surrender = money - price;
        for (int coin : coins) {
            while (surrender >= coin) {
                surrender = surrender - coin;
                rsl[size++] = coin;
            }
            if (surrender == 0) {
                break;
            }
        }
        return Arrays.copyOf(rsl, size);
    }
}
