package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 1/10/2021
 */
@LeetCode(
		id = 1649,
		name = "Create Sorted Array through Instructions",
		url = "https://leetcode.com/problems/create-sorted-array-through-instructions/",
		difficulty = Difficulty.HARD
)
public class CreateSortedArrayThroughInstructions {
	class FenwikTree {
		int[] table;

		public FenwikTree(int n) {
			table = new int[n];
		}

		public void update(int index, int value) {
			index++;
			while (index < table.length) {
				table[index] += value;
				index += 1 << getLeastSignificantBit(index);
			}
		}

		public int query(int index) {
			index++;
			int result = 0;
			while (index >= 1) {
				result += table[index];
				index -= 1 << getLeastSignificantBit(index);
			}

			return result;
		}

		private int getLeastSignificantBit(int i) {
			int shift = 0;
			while ((i & 1 << shift) == 0) {
				shift++;
			}
			return shift;
		}
	}

	public int createSortedArray(int[] instructions) {
		FenwikTree fenwikTree = new FenwikTree(100_002);
		int mod = 1_000_000_007;
		int cost = 0;
		int leftCost;
		int rightCost;
		for (int i = 0; i < instructions.length; i++) {
			leftCost = fenwikTree.query(instructions[i] - 1);
			rightCost = i - fenwikTree.query(instructions[i]);

			cost = (cost + Math.min(leftCost, rightCost) % mod) % mod;
			fenwikTree.update(instructions[i], 1);
		}

		return cost;
	}

	public static void main(String[] args) throws Exception {
		CreateSortedArrayThroughInstructions clazz = new CreateSortedArrayThroughInstructions();
		System.out.println(clazz.createSortedArray(new int[]{1, 3, 3, 3, 2, 4, 2, 1, 2}));
		System.out.println(clazz.createSortedArray(new int[]{1, 2, 3, 6, 5, 4}));
		System.out.println(clazz.createSortedArray(new int[]{1, 5, 6, 2}));
	}
}
