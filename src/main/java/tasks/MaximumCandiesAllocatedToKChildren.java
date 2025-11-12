package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-13
 */
@LeetCode(
        id = 2226,
        name = "Maximum Candies Allocated to K Children",
        url = "https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description",
        difficulty = Difficulty.MEDIUM
)
public class MaximumCandiesAllocatedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int candle : candies) {
            sum += candle;
        }

        if (sum < k) {
            return 0;
        } else if (sum == k) {
            return 1;
        }

        Arrays.sort(candies);

        int ans = 1;
        int left = 1;
        int right = candies[candies.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canBeSplit(candies, mid, k)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }


        return ans;
    }

    private boolean canBeSplit(int[] candies, long target, long k) {
        for (int i = candies.length - 1; i >= 0; i--) {
            if (candies[i] < target || k <= 0) {
                break;
            }

            k -= candies[i] / target;
        }

        return k <= 0;
    }
}