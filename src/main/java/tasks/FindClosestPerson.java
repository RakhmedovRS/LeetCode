package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-09-03
 */
@LeetCode(
        id = 3516,
        name = "Find Closest Person",
        url = "https://leetcode.com/problems/find-closest-person/description",
        difficulty = Difficulty.EASY
)
public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        if (Math.abs(z - x) == Math.abs(z - y)) {
            return 0;
        }

        if (Math.abs(z - x) > Math.abs(z - y)) {
            return 2;
        }

        return 1;
    }
}