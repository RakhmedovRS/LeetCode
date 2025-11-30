package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-29
 */
@LeetCode(
        id = 3761,
        name = "Minimum Absolute Distance Between Mirror Pairs",
        url = "https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        Map<Long, Integer> seen = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            long reverse = Long.parseLong(new StringBuilder("" + nums[i]).reverse().toString());
            if (seen.containsKey(reverse)) {
                ans = Math.min(ans, seen.get(reverse) - i);
            }

            seen.put((long) nums[i], i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}