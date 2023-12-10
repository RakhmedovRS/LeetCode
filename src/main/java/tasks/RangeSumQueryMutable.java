package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 11/19/2020
 */
@LeetCode(
		id = 307,
		name = "Range Sum Query - Mutable",
		url = "https://leetcode.com/problems/range-sum-query-mutable/",
		difficulty = Difficulty.MEDIUM
)
public class RangeSumQueryMutable {
	class NumArray {
		int[] original;
		int[] table;

		public NumArray(int[] nums) {
			original = new int[nums.length + 1];
			table = new int[nums.length + 1];
			System.arraycopy(nums, 0, original, 1, nums.length);

			int nextPos;
			for (int i = 1; i < table.length; i++) {
				table[i] += nums[i - 1];
				nextPos = i + (1 << getLeastSignificantBit(i));
				if (nextPos < table.length) {
					table[nextPos] += table[i];
				}
			}
		}

		public void update(int pos, int value) {
			int prev = original[pos + 1];
			original[pos + 1] = value;
			pos++;
			while (pos < table.length) {
				table[pos] -= prev;
				table[pos] += value;
				pos += 1 << getLeastSignificantBit(pos);
			}
		}

		public int sumRange(int i, int j) {
			return calcSum(j + 1) - calcSum(i);
		}

		private int calcSum(int pos) {
			int sum = 0;
			while (pos != 0) {
				sum += table[pos];
				pos -= 1 << getLeastSignificantBit(pos);
			}

			return sum;
		}

		private int getLeastSignificantBit(int number) {
			int i = 0;
			while ((number & (1 << i)) == 0) {
				i++;
			}

			return i;
		}
	}

	public static void main(String[] args) {
		NumArray numArray = new RangeSumQueryMutable().new NumArray(new int[]{0, 9, 5, 7, 3});
		System.out.println(numArray.sumRange(4, 4)); //3
		System.out.println(numArray.sumRange(2, 4)); //15

		System.out.println();

		numArray = new RangeSumQueryMutable().new NumArray(new int[]{9, -8});
		numArray.update(0, 3);
		System.out.println(numArray.sumRange(1, 1)); //-8
		System.out.println(numArray.sumRange(0, 1)); //-5
		numArray.update(1, -3);
		System.out.println(numArray.sumRange(0, 1)); //0

		System.out.println();

		numArray = new RangeSumQueryMutable().new NumArray(new int[]{1, 3, 5});
		System.out.println(numArray.sumRange(0, 2));//9
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2)); // 8
	}
}
