package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-01-20
 */
@LeetCode(
		id = 3011,
		name = "Find if Array Can Be Sorted",
		url = "https://leetcode.com/problems/find-if-array-can-be-sorted/description/",
		difficulty = Difficulty.MEDIUM
)
public class FindIfArrayCanBeSorted {
	class UnionFind {
		private final int[] parents;
		private final int[] elements;

		public UnionFind(int[] elements) {
			this.elements = elements;
			parents = new int[elements.length];
			for (int i = 0; i < elements.length; i++) {
				parents[i] = i;
			}
		}

		public int getParent(int node) {
			int parent = parents[node];
			while (parent != parents[parent]) {
				parent = parents[parent];
			}

			while (node != parent) {
				parents[node] = parent;
				node = parents[node];
			}

			return parent;
		}

		public void join(int nodeA, int nodeB) {
			int parentA = getParent(nodeA);
			int parentB = getParent(nodeB);

			if (parentA != parentB) {
				parents[nodeB] = parentA;
			}
		}

		private Map<Integer, int[]> getMinMaxes() {
			Map<Integer, int[]> minMaxes = new HashMap<>();
			for (int i = 0; i < elements.length; i++) {
				final int a = i;
				int[] minMax = minMaxes.computeIfAbsent(getParent(i), (parent) -> new int[]{elements[a], elements[a]});
				minMax[0] = Math.min(minMax[0], elements[i]);
				minMax[1] = Math.max(minMax[1], elements[i]);
			}

			return minMaxes;
		}
	}

	public boolean canSortArray(int[] nums) {
		int[] sortedCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(sortedCopy);

		boolean sorted = true;
		for (int i = 0; i < nums.length && sorted; i++) {
			if (nums[i] != sortedCopy[i]) {
				sorted = false;
			}
		}

		if (sorted) {
			return true;
		}

		UnionFind uf = new UnionFind(nums);
		Integer[] bits = new Integer[32];
		for (int i = 0; i < nums.length; i++) {
			int bitCount = Integer.bitCount(nums[i]);
			if (bits[bitCount] != null) {
				uf.join(bits[bitCount], i);
			} else {
				bits[bitCount] = i;
			}
		}

		Map<Integer, int[]> minMaxes = uf.getMinMaxes();
		for (int i = 1; i < nums.length; i++) {
			int prevParent = uf.getParent(i - 1);
			int currParent = uf.getParent(i);

			if (prevParent != currParent) {
				int[] minMaxPrev = minMaxes.get(prevParent);
				int[] minMaxCurr = minMaxes.get(currParent);

				if (minMaxPrev[1] > minMaxCurr[0]) {
					return false;
				}
			}
		}

		return true;
	}
}