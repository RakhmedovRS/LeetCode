package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-08-23
 */
@LeetCode(
        id = 3659,
        name = "Partition Array Into K-Distinct Groups",
        url = "https://leetcode.com/problems/partition-array-into-k-distinct-groups/description/",
        difficulty = Difficulty.MEDIUM
)
public class PartitionArrayIntoKDistinctGroups {
    public boolean partitionArray(int[] nums, int k) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            memo.put(num, memo.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> memo.getOrDefault(b, 0).compareTo(memo.getOrDefault(a, 0)));
        pq.addAll(memo.keySet());

        while (pq.size() >= k) {
            Set<Integer> used = new HashSet<>();
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                int curr = pq.poll();
                used.add(curr);
            }

            if (used.size() == k) {
                for (int u : used) {
                    int count = memo.remove(u);
                    if (--count > 0) {
                        memo.put(u, count);
                        pq.add(u);
                    }
                }
            }
        }
        return pq.isEmpty();
    }
}