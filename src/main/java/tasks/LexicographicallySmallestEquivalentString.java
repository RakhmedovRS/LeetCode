package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/21/2021
 */
@LeetCode(
		id = 1061,
		name = "Lexicographically Smallest Equivalent String",
		url = "https://leetcode.com/problems/lexicographically-smallest-equivalent-string/",
		difficulty = Difficulty.MEDIUM,
		premium = true
)
public class LexicographicallySmallestEquivalentString {
	class UnionFind {
		int[] parents;

		public UnionFind(int n) {
			parents = new int[n];
			for (int i = 0; i < n; i++) {
				parents[i] = i;
			}
		}

		public int findParent(int node) {
			int parent = node;
			while (parent != parents[parent]) {
				parent = parents[parent];
			}

			int next;
			while (node != parents[node]) {
				next = parents[node];
				parents[node] = parent;
				node = next;
			}

			return parent;
		}

		public void join(int nodeA, int nodeB) {
			int parentA = findParent(nodeA);
			int parentB = findParent(nodeB);

			if (parentA != parentB) {
				if (parentB > parentA) {
					parents[parentB] = parentA;
				}
				else {
					parents[parentA] = parentB;
				}
			}
		}
	}

	public String smallestEquivalentString(String A, String B, String S) {
		UnionFind uf = new UnionFind(26);
		for (int i = 0; i < A.length(); i++) {
			uf.join(A.charAt(i) - 'a', B.charAt(i) - 'a');
		}

		StringBuilder sb = new StringBuilder();
		for (char ch : S.toCharArray()) {
			sb.append((char) (uf.findParent(ch - 'a') + 'a'));
		}

		return sb.toString();
	}
}
