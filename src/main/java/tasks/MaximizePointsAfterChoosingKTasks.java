package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-12-06
 */
@LeetCode(
        id = 3767,
        name = "Maximize Points After Choosing K Tasks",
        url = "https://leetcode.com/problems/maximize-points-after-choosing-k-tasks/description/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizePointsAfterChoosingKTasks {
    public long maxPoints(int[] technique1, int[] technique2, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (technique1[a] - technique2[a]) - (technique1[b] - technique2[b]));
        for (int i = 0; i < technique1.length; i++) {
            pq.add(i);
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            int pos = pq.remove();
            if (technique2[pos] >= technique1[pos] && pq.size() >= k) {
                ans += technique2[pos];
            } else {
                ans += technique1[pos];
                k--;
            }
        }

        return ans;
    }
}