package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/10/2021
 */
@LeetCode(
		id = 1722,
		name = "Minimize Hamming Distance After Swap Operations",
		url = "https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/",
		difficulty = Difficulty.MEDIUM
)
public class MinimizeHammingDistanceAfterSwapOperations {
	class UnionFind {
		int[] parents;
		int[] rank;

		public UnionFind(int n) {
			parents = new int[n];
			rank = new int[n];

			for (int i = 0; i < n; i++) {
				parents[i] = i;
				rank[i] = 1;
			}
		}

		private int parent(int nodeA) {
			int root = nodeA;
			while (parents[root] != root) {
				root = parents[root];
			}

			int temp;
			while (parents[nodeA] != nodeA) {
				temp = parents[nodeA];
				parents[nodeA] = root;
				nodeA = temp;
			}

			return root;
		}

		private void join(int nodeA, int nodeB) {
			int parentA = parent(nodeA);
			int parentB = parent(nodeB);

			if (parentA != parentB) {
				if (rank[parentA] >= rank[parentB]) {
					rank[parentA] += rank[parentB];
					parents[parentB] = parentA;
				}
				else {
					rank[parentB] += rank[parentA];
					parents[parentA] = parentB;
				}
			}
		}
	}

	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		UnionFind uf = new UnionFind(source.length);
		for (int[] swap : allowedSwaps) {
			uf.join(swap[0], swap[1]);
		}

		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < source.length; i++) {
			int parent = uf.parent(i);
			Map<Integer, Integer> innerMap = map.getOrDefault(parent, new HashMap<>());
			innerMap.put(source[i], innerMap.getOrDefault(source[i], 0) + 1);
			map.put(parent, innerMap);
		}

		int diff = 0;

		for (int i = 0; i < target.length; i++) {
			int parent = uf.parent(i);
			Map<Integer, Integer> innerMap = map.get(parent);
			if (!innerMap.containsKey(target[i])) {
				diff++;
			}
			else {
				int count = innerMap.remove(target[i]) - 1;
				if (count > 0) {
					innerMap.put(target[i], count);
				}
			}
		}

		return diff;
	}

	public static void main(String[] args) {
		MinimizeHammingDistanceAfterSwapOperations clazz = new MinimizeHammingDistanceAfterSwapOperations();

		System.out.println(clazz.minimumHammingDistance(
				new int[]{99, 80, 67, 9, 61, 50, 39, 46, 18, 62, 98, 39, 26, 95, 26, 50, 17, 44, 69, 21, 72, 38, 31, 52, 6, 73, 33, 68, 70, 18, 68, 99, 85, 55, 19},
				new int[]{96, 69, 22, 58, 61, 50, 90, 30, 10, 12, 47, 53, 26, 54, 26, 37, 81, 43, 76, 27, 13, 76, 53, 25, 6, 51, 9, 12, 12, 90, 63, 94, 50, 25, 6},
				new int[][]{{1, 34}, {30, 24}, {6, 9}, {31, 5}, {17, 10}, {20, 0}, {15, 20}, {6, 17}, {11, 23}, {11, 28}, {26, 28}, {7, 0}, {25, 7}, {12, 31},
						{2, 22}, {10, 0}, {20, 2}, {30, 13}, {7, 22}, {14, 30}, {23, 34}, {24, 8}, {31, 14}, {19, 4}, {21, 9}, {24, 27}, {6, 10}, {34, 21}, {34, 0},
						{26, 25}, {7, 19}, {21, 31}, {17, 12}, {17, 23}, {28, 7}, {28, 22}, {31, 1}, {27, 28}, {20, 18}, {8, 15}, {23, 25}, {34, 33}, {17, 0}, {2, 1},
						{9, 14}, {7, 10}, {30, 29}, {23, 3}, {10, 13}, {21, 8}, {5, 24}, {16, 4}, {2, 32}, {9, 16}, {29, 15}, {6, 23}, {21, 5}, {28, 32}, {10, 23},
						{30, 0}, {19, 16}, {22, 12}, {6, 8}, {1, 0}, {22, 25}, {12, 3}, {2, 25}, {1, 12}, {12, 8}, {18, 10}, {4, 15}, {2, 11}, {3, 27}, {14, 5},
						{4, 26}, {14, 10}, {9, 30}, {8, 18}, {27, 5}, {4, 21}, {19, 23}, {27, 34}, {9, 19}, {16, 15}, {21, 24}, {4, 32}, {11, 16}, {21, 1}, {27, 0},
						{15, 33}, {25, 18}, {12, 27}, {14, 28}, {26, 1}, {32, 20}, {26, 22}, {13, 26}, {3, 11}, {1, 15}, {33, 14}, {28, 3}, {31, 4}, {33, 19}, {33, 1},
						{15, 26}, {14, 6}, {30, 5}, {26, 20}, {3, 34}, {27, 33}, {9, 20}, {29, 6}, {6, 0}, {20, 21}, {31, 11}, {1, 16}, {6, 32}, {12, 24}, {1, 5},
						{17, 24}, {16, 32}, {6, 3}, {18, 31}, {34, 14}, {17, 30}, {33, 25}, {8, 25}, {32, 33}, {28, 4}, {28, 19}, {27, 30}, {33, 26}, {33, 21},
						{20, 31}, {33, 3}, {19, 10}, {0, 18}, {23, 16}, {30, 6}, {21, 30}, {12, 18}, {11, 26}, {1, 19}, {31, 7}, {29, 22}, {11, 15}, {27, 31}, {31, 26},
						{23, 24}, {2, 7}, {13, 9}, {4, 6}, {31, 25}, {18, 17}, {7, 5}, {20, 33}, {19, 27}, {33, 2}, {24, 25}, {11, 20}, {23, 33}, {6, 27}, {30, 1},
						{0, 2}, {34, 7}, {23, 31}, {28, 29}, {18, 5}, {19, 13}, {32, 15}, {4, 27}, {3, 21}, {34, 25}, {19, 8}, {26, 14}, {4, 22}, {19, 22}, {13, 11},
						{9, 18}, {33, 22}, {17, 3}, {4, 33}, {11, 19}, {28, 0}, {20, 7}, {27, 15}, {12, 20}, {33, 9}, {28, 17}, {23, 14}, {25, 13}, {10, 3}, {30, 2},
						{27, 18}, {13, 4}, {34, 9}, {11, 9}, {8, 29}, {34, 24}, {9, 24}, {8, 16}, {6, 15}, {29, 5}, {13, 14}, {21, 19}, {25, 29}, {7, 14}, {6, 18},
						{12, 14}, {30, 11}, {1, 23}, {0, 25}, {6, 33}, {23, 21}, {12, 25}, {12, 15}, {1, 4}, {31, 17}, {33, 16}, {25, 16}, {9, 3}, {3, 2}, {9, 1},
						{32, 1}, {14, 29}, {26, 0}, {29, 4}, {19, 31}, {27, 9}, {24, 29}, {16, 14}, {5, 16}, {20, 24}, {32, 3}, {16, 10}, {7, 13}, {32, 29}, {11, 29},
						{18, 1}, {17, 21}, {27, 16}, {30, 7}, {12, 30}, {10, 33}, {1, 7}, {27, 23}, {18, 32}, {17, 1}, {2, 4}, {7, 4}, {18, 11}, {23, 8}, {34, 12},
						{34, 20}, {26, 19}, {19, 5}, {34, 28}, {10, 21}, {0, 16}, {7, 16}, {11, 24}, {3, 0}, {29, 7}, {32, 31}, {18, 23}, {28, 15}, {23, 30}, {16, 24},
						{12, 33}, {9, 2}, {15, 9}, {5, 12}, {8, 1}, {34, 32}, {2, 28}, {25, 5}, {4, 23}, {25, 19}, {27, 10}, {17, 4}, {18, 15}, {22, 6}, {5, 22},
						{28, 33}, {30, 34}, {22, 14}, {18, 16}, {12, 21}, {16, 2}, {24, 1}, {15, 13}, {13, 24}, {32, 17}, {7, 17}, {2, 8}, {3, 30}, {2, 10}, {9, 10},
						{8, 30}, {15, 5}, {9, 31}, {17, 8}, {4, 9}, {0, 12}, {25, 28}, {23, 15}, {6, 19}, {21, 25}, {23, 20}, {11, 17}, {8, 34}, {26, 7}, {24, 10},
						{21, 22}, {17, 20}, {10, 1}, {13, 0}, {32, 11}, {29, 18}, {33, 11}, {32, 14}, {15, 2}, {15, 14}, {8, 27}, {24, 32}, {4, 30}, {30, 19}}));

		System.out.println(clazz.minimumHammingDistance(new int[]{5, 1, 2, 4, 3}, new int[]{1, 5, 4, 2, 3}, new int[][]{{0, 4}, {4, 2}, {1, 3}, {1, 4}}));
		System.out.println(clazz.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{2, 1, 4, 5}, new int[][]{{0, 1}, {2, 3}}));
		System.out.println(clazz.minimumHammingDistance(new int[]{1, 2, 3, 4}, new int[]{1, 3, 2, 4}, new int[0][]));
	}
}
