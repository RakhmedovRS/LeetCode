package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-01
 */
@LeetCode(
        id = 3471,
        name = "Find the Largest Almost Missing Integer",
        url = "https://leetcode.com/problems/find-the-largest-almost-missing-integer/description/",
        difficulty = Difficulty.EASY
)
public class FindTheLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        int left = 0;
        int right = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        int len = 0;
        while (right < nums.length) {
            seen.put(nums[right], seen.getOrDefault(nums[right++], 0) + 1);
            len++;
            if (len > k) {
                int num = nums[left++];
                int count = seen.remove(num);
                if (--count > 0) {
                    seen.put(num, count);
                }
                len--;
            }

            if (len == k) {
                for (int num : seen.keySet()) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return -1;
    }
}