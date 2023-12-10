package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10/2/2020
 */
@LeetCode(
		id = 684,
		name = "Redundant Connection",
		url = "https://leetcode.com/problems/redundant-connection/",
		difficulty = Difficulty.MEDIUM
)
public class RedundantConnection {
	class UnionFind {
		int[] parents;

		public UnionFind(int n) {
			parents = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
		}

		public int getParent(int node) {
			int parent = node;
			while (parents[parent] != parent) {
				parent = parents[parent];
			}

			int temp;
			while (parents[node] != parent) {
				temp = parents[node];
				parents[node] = parent;
				node = temp;
			}

			return parent;
		}

		public boolean connect(int nodeA, int nodeB) {
			int parentA = getParent(nodeA);
			int parentB = getParent(nodeB);

			if (parentA == parentB) {
				return false;
			}

			parents[parentB] = parentA;

			return true;
		}
	}

	public int[] findRedundantConnection(int[][] edges) {
		UnionFind unionFind = new UnionFind(edges.length);
		int[] candidate = new int[]{};
		for (int[] edge : edges) {
			if (!unionFind.connect(edge[0], edge[1])) {
				candidate = edge;
			}
		}

		return candidate;
	}
}
