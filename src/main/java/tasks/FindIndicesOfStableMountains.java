package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-10-03
 */
@LeetCode(
        id = 3285,
        name = "Find Indices of Stable Mountains",
        url = "https://leetcode.com/problems/find-indices-of-stable-mountains/description/",
        difficulty = Difficulty.EASY
)
public class FindIndicesOfStableMountains {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> mountains = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold && height[i] > 0) {
                mountains.add(i);
            }
        }
        return mountains;
    }
}