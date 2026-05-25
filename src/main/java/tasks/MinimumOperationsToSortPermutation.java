package tasks;
import common.Difficulty;
import common.LeetCode;
import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-05-25
 */
@LeetCode(
id = 3942,
 name = "Minimum Operations to Sort a Permutation",
 url = "https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/description/",
 difficulty = Difficulty.MEDIUM
)
public class MinimumOperationsToSortPermutation {
    public int minOperations(int[] nums) {
        boolean increment = true;
        boolean decrement = true;
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {

            if (nums[(i + 1) % n] != (nums[i] + 1) % n) {
                increment = false;
            }

            if (nums[(i + 1) % n] != (nums[i] - 1 + n) % n) {
                decrement = false;
            }
        }

        if (!increment && !decrement) {
            return -1;
        }


        boolean sorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= nums[i]) {
                sorted = false;
                break;
            }
        }

        if (sorted) {
            return 0;
        }

        int minPos = 0;
        int maxPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[minPos] > nums[i]) {
                minPos = i;
            }

            if (nums[maxPos] < nums[i]) {
                maxPos = i;
            }
        }

        int ans = Integer.MAX_VALUE;
        if (increment) {
            ans = minPos;
            ans = Math.min(ans, 2 + ((n - minPos) % n));
        }

        if (decrement) {
            ans = Math.min(ans, 1 + (n - 1 - minPos));
            ans = Math.min(ans, minPos + 2);
        }

        return ans;
    }
}