package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-05-29
 */
@LeetCode(
        id = 2359,
        name = "Find Closest Node to Given Two Nodes",
        url = "https://leetcode.com/problems/find-closest-node-to-given-two-nodes/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        if (node1 == node2) {
            return node1;
        }

        Map<Integer, Integer> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != -1) {
                graph.put(i, edges[i]);
            }
        }


        int[][] visited = new int[edges.length][2];
        for (int[] row : visited) {
            Arrays.fill(row, -1);
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{node1, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            int pos = curr[0];
            int distance = curr[1];
            if (visited[pos][0] != -1 && visited[pos][0] <= distance) {
                continue;
            }
            visited[pos][0] = distance;
            if (graph.containsKey(pos)) {
                queue.addLast(new int[]{graph.get(pos), distance + 1});
            }
        }

        queue = new LinkedList<>();
        queue.addLast(new int[]{node2, 0});
        int minDistance = Integer.MAX_VALUE;
        int minNode = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] curr = queue.removeFirst();
            int pos = curr[0];
            int distance = curr[1];
            if (visited[pos][0] != -1) {
                int max = Math.max(visited[pos][0], distance);
                if (max < minDistance) {
                    minDistance = max;
                    minNode = pos;
                } else if (max == minDistance) {
                    minNode = Math.min(minNode, pos);
                }
            }

            if (visited[pos][1] != -1 && visited[pos][1] <= distance) {
                continue;
            }
            visited[pos][1] = distance;
            if (graph.containsKey(pos)) {
                queue.addLast(new int[]{graph.get(pos), distance + 1});
            }
        }
        return minNode == Integer.MAX_VALUE ? -1 : minNode;
    }
}