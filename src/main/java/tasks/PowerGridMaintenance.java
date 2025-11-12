package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-11-05
 */
@LeetCode(
        id = 3607,
        name = "Power Grid Maintenance",
        url = "https://leetcode.com/problems/power-grid-maintenance/description/",
        difficulty = Difficulty.MEDIUM
)
public class PowerGridMaintenance {
    class UnionFind {
        int[] parents;
        int[] size;
        Map<Integer, TreeSet<Integer>> components;

        public UnionFind(int nodes) {
            this.parents = new int[nodes + 1];
            this.size = new int[nodes + 1];
            for (int i = 1; i <= nodes; i++) {
                parents[i] = i;
            }
            components = new HashMap<>();
            Arrays.fill(size, 1);
        }

        public int findParent(int node) {
            int parent = node;
            while (parents[parent] != parent) {
                parent = parents[parent];
            }

            while (parents[node] != parent) {
                int next = parents[node];
                parents[node] = parent;
                node = next;
            }
            return parent;
        }

        public void join(int nodeA, int nodeB) {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            if (parentA != parentB) {
                if (size[parentA] >= size[parentB]) {
                    parents[parentB] = parentA;
                    size[parentA] += size[parentB];
                } else {
                    parents[parentA] = parentB;
                    size[parentB] += size[parentA];
                }
            }
        }

        public void buildMap() {
            for (int i = 1; i < parents.length; i++) {
                int parent = findParent(i);
                components.computeIfAbsent(parent, P -> new TreeSet<>()).add(i);
            }
        }

        public int maintenance(int node) {
            int parent = findParent(node);
            TreeSet<Integer> nodes = components.get(parent);
            if (nodes.contains(node)) {
                return node;
            } else if (!nodes.isEmpty()) {
                return nodes.first();
            }
            return -1;
        }

        public void shutdown(int node) {
            int parent = findParent(node);
            TreeSet<Integer> nodes = components.get(parent);
            nodes.remove(node);
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind uf = new UnionFind(c);
        for (int[] connection : connections) {
            uf.join(connection[0], connection[1]);
        }

        uf.buildMap();
        int[] ans = new int[queries.length];
        int pos = 0;
        for (int[] query : queries) {
            if (query[0] == 1) {
                ans[pos++] = uf.maintenance(query[1]);
            } else {
                uf.shutdown(query[1]);
            }
        }

        return Arrays.copyOf(ans, pos);
    }
}