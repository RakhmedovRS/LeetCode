package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-08
 */
@LeetCode(
        id = 3478,
        name = "Choose K Elements With Maximum Sum",
        url = "https://leetcode.com/problems/choose-k-elements-with-maximum-sum/description/",
        difficulty = Difficulty.MEDIUM
)
public class ChooseKElementsWithMaximumSum {
    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        List<int[]> NUMS1 = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            NUMS1.add(new int[]{nums1[i], i});
        }

        NUMS1.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        long sum = 0;
        TreeSet<int[]> seen = new TreeSet<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        long[] ans = new long[NUMS1.size()];
        Map<Integer, Long> results = new HashMap<>();
        for (int[] ints : NUMS1) {
            int index = ints[1];
            if (results.containsKey(ints[0])) {
                ans[index] = results.get(ints[0]);
            } else {
                ans[index] = sum;
                results.put(ints[0], sum);
            }

            sum += nums2[index];
            seen.add(new int[]{nums2[index], index});
            if (seen.size() > k) {
                int[] rem = seen.pollFirst();
                sum -= rem[0];
            }
        }

        return ans;
    }
}