package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-11-30
 */
@LeetCode(
        id = 3372,
        name = "Maximize the Number of Target Nodes After Connecting Trees I",
        url = "https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/",
        difficulty = Difficulty.MEDIUM
)
public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {
    class Node {
        int value;
        Set<Integer> neighbors;
        int count;

        public Node(int value) {
            this.value = value;
            neighbors = new HashSet<>();
        }
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        Map<Integer, Node> graph1 = buildGraph(edges1);
        Map<Integer, Node> graph2 = buildGraph(edges2);
        exploreGraph(graph1, k);
        exploreGraph(graph2, k - 1);
        int pos = 0;
        int[] ans = new int[graph1.size()];
        int tree2Max = 0;
        for (Node node2 : graph2.values()) {
            tree2Max = Math.max(tree2Max, node2.count);
        }

        for (Node node1 : graph1.values()) {
            ans[pos] = Math.max(ans[pos], node1.count + tree2Max);
            pos++;
        }
        return ans;
    }

    private Map<Integer, Node> buildGraph(int[][] edges) {
        Map<Integer, Node> graph = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            graph.computeIfAbsent(a, A -> new Node(a));
            graph.computeIfAbsent(b, B -> new Node(b));
            graph.get(a).neighbors.add(b);
            graph.get(b).neighbors.add(a);
        }
        return graph;
    }

    private void exploreGraph(Map<Integer, Node> graph, int k) {
        for (Integer nodeValue : graph.keySet()) {
            Set<Integer> visited = new HashSet<>();
            LinkedList<int[]> queue = new LinkedList<>();
            queue.add(new int[]{nodeValue, 0});
            while (!queue.isEmpty()) {
                int[] current = queue.removeFirst();
                Node node = graph.get(current[0]);
                int distance = current[1];
                if (!visited.add(node.value) || distance > k) {
                    continue;
                }
                node.count++;

                for (int neighbor : node.neighbors) {
                    queue.addLast(new int[]{neighbor, distance + 1});
                }
            }
        }
    }
}