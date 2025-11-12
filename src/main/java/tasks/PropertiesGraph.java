package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author Ruslan Rakhmedov
 * @created 2025-03-23
 */
@LeetCode(
        id = 3493,
        name = "Properties Graph",
        url = "https://leetcode.com/problems/properties-graph/description/",
        difficulty = Difficulty.MEDIUM
)
public class PropertiesGraph {
    public class UnionFind {
        int[] rank;
        int[] parents;

        public UnionFind(int n) {
            rank = new int[n];
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                parents[i] = i;
            }
        }

        public int findParent(int node) {
            int parent = node;
            while (parent != parents[parent]) {
                parent = parents[parent];
            }

            int temp;
            while (node != parents[node]) {
                temp = parents[node];
                parents[node] = parent;
                node = temp;
            }

            return parent;
        }

        public boolean union(int nodeA, int nodeB) {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);

            if (parentA != parentB) {
                if (rank[parentA] >= rank[parentB]) {
                    rank[parentA] += rank[parentB];
                    parents[parentB] = parentA;
                } else {
                    rank[parentB] += rank[parentA];
                    parents[parentA] = parentB;
                }

                return true;
            }

            return false;
        }
    }

    public int numberOfComponents(int[][] properties, int k) {
        int rows = properties.length;
        int columns = properties[0].length;
        int[][] memo = new int[rows][101];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                memo[row][properties[row][column]]++;
            }
        }


        UnionFind uf = new UnionFind(rows);
        for (int i = 0; i < memo.length; i++) {
            for (int j = i + 1; j < memo.length; j++) {
                if (intersect(memo[i], memo[j], k)) {
                    uf.union(i, j);
                }
            }
        }

        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < memo.length; i++) {
            parents.add(uf.findParent(i));
        }

        return parents.size();
    }

    private boolean intersect(int[] memoA, int[] memoB, int k) {
        int inter = 0;
        for (int i = 0; i < memoA.length; i++) {
            if (memoA[i] > 0 && memoB[i] > 0) {
                inter++;
            }
        }
        return inter >= k;
    }
}