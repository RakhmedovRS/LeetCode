package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-03-07
 */
@LeetCode(
        id = 3861,
        name = "Minimum Capacity Box",
        url = "https://leetcode.com/problems/minimum-capacity-box/description/",
        difficulty = Difficulty.EASY
)
public class MinimumCapacityBox {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans = -1;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize) {
                if (ans == -1) {
                    ans = i;
                } else {
                    if (capacity[ans] > capacity[i]) {
                        ans = i;
                    }
                }
            }
        }
        return ans;
    }
}