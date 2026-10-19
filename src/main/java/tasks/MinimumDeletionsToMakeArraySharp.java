package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4083,
        name = "Minimum Deletions to Make Array Sharp",
        url = "https://leetcode.com/problems/minimum-deletions-to-make-array-sharp/description/",
        difficulty = Difficulty.EASY
)
public class MinimumDeletionsToMakeArraySharp {
    public int minDeletions(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i - 1] ^ nums[i]) == 0) {
                ans++;
            }
        }
        return ans;
    }
}