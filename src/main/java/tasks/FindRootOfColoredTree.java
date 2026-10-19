package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2026-10-18
 */
@LeetCode(
        id = 4085,
        name = "Find Root of a Colored Tree",
        url = "https://leetcode.com/problems/find-root-of-a-colored-tree/description/",
        difficulty = Difficulty.MEDIUM
)
public class FindRootOfColoredTree {
    public int findColoredRoot(int[][] edges, String colors) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Character, Character> sequence = new HashMap<>();
        sequence.put('R', 'B');
        sequence.put('B', 'W');
        sequence.put('W', 'R');

        int[] degree = new int[edges.length + 1];
        for (int[] edge : edges) {
            int U = edge[0];
            int V = edge[1];

            char uColor = colors.charAt(U);
            char vColor = colors.charAt(V);

            if (vColor == sequence.get(uColor)) {
                degree[V]++;
            } else if (uColor == sequence.get(vColor)) {
                degree[U]++;
            } else {
                return -1;
            }

            graph.computeIfAbsent(edge[0], E -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], E -> new ArrayList<>()).add(edge[0]);
        }

        int candidate = -1;
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                if (candidate != -1) {
                    return -1;
                }
                candidate = i;
            }
        }

        if (candidate != -1) {
            if (graph.get(candidate).size() > 2) {
                return -1;
            }
        }
        return candidate;
    }
}