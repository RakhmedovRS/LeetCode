package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-02-15
 */
@LeetCode(
        id = 3457,
        name = "Eat Pizzas!",
        url = "https://leetcode.com/problems/eat-pizzas/description/",
        difficulty = Difficulty.MEDIUM
)
public class EatPizzas {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        TreeSet<Integer> indices = new TreeSet<>();
        for (int i = 0; i < pizzas.length; i++) {
            indices.add(i);
        }

        long ans = 0;
        for (int i = 0; i < (pizzas.length / 4 + 1) / 2; i++) {
            ans += pizzas[indices.last()];
            indices.remove(indices.first());
            indices.remove(indices.first());
            indices.remove(indices.first());
            indices.remove(indices.last());
        }

        while (!indices.isEmpty()) {
            indices.remove(indices.last());
            ans += pizzas[indices.last()];
            indices.remove(indices.last());
            indices.remove(indices.first());
            indices.remove(indices.first());
        }
        return ans;
    }
}