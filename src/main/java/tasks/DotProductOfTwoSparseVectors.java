package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 1/4/2021
 */
@LeetCode(
		id = 1570,
		name = "Dot Product of Two Sparse Vectors",
		url = "https://leetcode.com/problems/dot-product-of-two-sparse-vectors/",
		difficulty = Difficulty.MEDIUM
)
public class DotProductOfTwoSparseVectors {
	class SparseVector {
		Map<Integer, Integer> positions;

		SparseVector(int[] nums) {
			positions = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					positions.put(i, nums[i]);
				}
			}

		}

		// Return the dotProduct of two sparse vectors
		public int dotProduct(SparseVector vec) {
			int result = 0;
			Map<Integer, Integer> vecPositions = vec.getPositions();
			for (Map.Entry<Integer, Integer> entry : positions.entrySet()) {
				result += entry.getValue() * vecPositions.getOrDefault(entry.getKey(), 0);
			}

			return result;
		}

		public Map<Integer, Integer> getPositions() {
			return positions;
		}
	}
}
