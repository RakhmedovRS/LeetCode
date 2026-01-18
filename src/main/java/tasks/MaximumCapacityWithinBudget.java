package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-01-17
 */
@LeetCode(
        id = 3814,
        name = "Maximum Capacity Within Budget",
        url = "https://leetcode.com/problems/maximum-capacity-within-budget/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximumCapacityWithinBudget {
    class Pair {
        int cost;
        int cap;

        public Pair(int cost, int cap) {
            this.cost = cost;
            this.cap = cap;
        }
    }

    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int max = 0;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            pairs.add(new Pair(costs[i], capacity[i]));
            if (costs[i] < budget) {
                max = Math.max(max, capacity[i]);
            }
        }

        pairs.sort((a, b) -> {
            if (a.cost == b.cost) {
                return a.cap - b.cap;
            }
            return a.cost - b.cost;
        });

        int[] leftToRight = new int[pairs.size()];
        leftToRight[0] = pairs.get(0).cap;
        for (int i = 1; i < pairs.size(); i++) {
            leftToRight[i] = Math.max(leftToRight[i - 1], pairs.get(i).cap);
        }


        int ans = 0;
        for (int pos = 0; pos < pairs.size(); pos++) {
            Pair left = pairs.get(pos);
            int targetCost = budget - left.cost;
            if (targetCost <= 0) {
                continue;
            }

            Integer right = BS(pos - 1, targetCost, pairs);
            if (right != null) {
                ans = Math.max(ans, left.cap + leftToRight[right]);
            }
        }

        return Math.max(max, ans);
    }

    private Integer BS(int right, int targetCost, List<Pair> pairs) {
        Integer max = null;
        if (targetCost <= 0) {
            return max;
        }
        int left = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Pair MID = pairs.get(mid);
            if (MID.cost < targetCost) {
                max = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return max;
    }
}