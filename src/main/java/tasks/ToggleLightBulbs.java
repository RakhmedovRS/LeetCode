package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-02-14
 */
@LeetCode(
        id = 3842,
        name = "Toggle Light Bulbs",
        url = "https://leetcode.com/problems/toggle-light-bulbs/description/",
        difficulty = Difficulty.EASY
)
public class ToggleLightBulbs {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        int[] memo = new int[101];
        for (int b : bulbs) {
            memo[b]++;
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < memo.length; i++) {
            if (memo[i] % 2 != 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}