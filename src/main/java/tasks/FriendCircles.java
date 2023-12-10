package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 24-Aug-20
 */
@LeetCode(id = 547, name = "Friend Circles", url = "https://leetcode.com/problems/friend-circles/")
public class FriendCircles {
	class UnionFind {
		int size;
		int[] length;
		int[] index;
		int numberOfComponents;

		public UnionFind(int size) {
			this.size = size;
			this.length = new int[size];
			this.index = new int[size];
			this.numberOfComponents = size;
			for (int i = 0; i < size; i++) {
				length[i] = i;
				index[i] = i;
			}
		}

		public int findParent(int node) {
			int root = node;
			while (root != index[root]) {
				root = index[root];
			}

			while (node != root) {
				int next = index[node];
				index[node] = root;
				node = next;
			}

			return root;
		}

		public void unify(int nodeA, int nodeB) {
			int rootA = findParent(nodeA);
			int rootB = findParent(nodeB);

			if (rootA == rootB) {
				return;
			}

			if (length[rootA] < length[rootB]) {
				length[rootB] += length[rootA];
				index[rootA] = rootB;
			}
			else {
				length[rootA] += length[rootB];
				index[rootB] = rootA;
			}

			numberOfComponents--;
		}
	}

	public int findCircleNum(int[][] M) {
		UnionFind unionFind = new UnionFind(M.length);
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if (M[i][j] == 1) {
					unionFind.unify(i, j);
				}
			}
		}

		return unionFind.numberOfComponents;
	}
}
