package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-08
 */
@LeetCode(
        id = 3477,
        name = "Fruits Into Baskets II",
        url = "https://leetcode.com/problems/fruits-into-baskets-ii/description/",
        difficulty = Difficulty.EASY
)
public class FruitsIntoBasketsII {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int misses = 0;
        outer:
        for (int fruit : fruits) {
            for (int i = 0; i < baskets.length; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    continue outer;
                }
            }
            misses++;
        }
        return misses;
    }
}