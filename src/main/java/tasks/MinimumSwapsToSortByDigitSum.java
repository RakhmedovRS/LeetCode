package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-18
 */
@LeetCode(
        id = 3551,
        name = "Minimum Swaps to Sort by Digit Sum",
        url = "https://leetcode.com/problems/minimum-swaps-to-sort-by-digit-sum/description/",
        difficulty = Difficulty.MEDIUM
)
public class MinimumSwapsToSortByDigitSum {
    public int minSwaps(int[] nums) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            pairs.add(new int[]{sum, i, nums[i]});
        }

        pairs.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[2] - b[2];
            }
            return a[0] - b[0];
        });

        Map<Integer, int[]> map = new HashMap<>();
        for (int[] pair : pairs) {
            map.put(pair[2], pair);
        }

        int swaps = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pairs.get(i)[2]) {
                int[] currentPair = pairs.get(i);
                int[] swapPair = map.get(nums[i]);
                int currIndex = currentPair[1];
                int swapIndex = swapPair[1];
                nums[i] = pairs.get(i)[2];
                nums[pairs.get(i)[1]] = swapPair[2];
                currentPair[1] = swapIndex;
                swapPair[1] = currIndex;
                swaps++;
            }
        }
        return swaps;
    }
}