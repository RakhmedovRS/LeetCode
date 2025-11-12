package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-07-19
 */
@LeetCode(
        id = 3620,
        name = "Network Recovery Pathways",
        url = "https://leetcode.com/problems/network-recovery-pathways/description/",
        difficulty = Difficulty.HARD
)
public class NetworkRecoveryPathways {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        Map<Integer, List<long[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            long b = edge[1];
            long cost = edge[2];
            graph.computeIfAbsent(a, (A -> new ArrayList<>()));
            graph.get(a).add(new long[]{b, cost});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[2] == a[2]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(b[2], a[2]);
        });

        pq.add(new long[]{0, 0, Integer.MAX_VALUE});

        Map<Integer, Long> memo = new HashMap<>();
        while (!pq.isEmpty()) {
            long[] curr = pq.remove();
            int node = (int) curr[0];
            long totalCost = curr[1];
            int minCost = (int) curr[2];

            if (node == online.length - 1) {
                if (totalCost <= k) {
                    return minCost;
                }
                continue;
            }

            if (!online[node] || totalCost > k) {
                continue;
            }

            if (memo.containsKey(node) && memo.get(node) <= totalCost) {
                continue;
            }

            memo.put(node, totalCost);

            for (long[] next : graph.getOrDefault(node, Collections.emptyList())) {
                pq.add(new long[]{next[0], totalCost + next[1], Math.min(minCost, next[1])});
            }
        }

        return -1;
    }
}