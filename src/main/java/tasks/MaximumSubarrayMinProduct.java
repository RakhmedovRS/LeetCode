package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 5/9/2021
 */
@LeetCode(
		id = 1856,
		name = "Maximum Subarray Min-Product",
		url = "https://leetcode.com/problems/maximum-subarray-min-product/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumSubarrayMinProduct {
	public int maxSumMinProduct(int[] nums) {
		java.math.BigInteger max = java.math.BigInteger.ZERO;
		long[] prefixSum = new long[nums.length + 1];
		for (int i = 1; i < prefixSum.length; i++) {
			prefixSum[i] += prefixSum[i - 1] + nums[i - 1];
		}

		int[] leftLower = new int[nums.length];
		int[] rightLower = new int[nums.length];

		Arrays.fill(leftLower, -1);
		Arrays.fill(rightLower, -1);

		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
				rightLower[stack.pop()] = i;
			}

			stack.push(i);
		}

		stack = new LinkedList<>();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
				leftLower[stack.pop()] = i;
			}

			stack.push(i);
		}

		for (int i = 0; i < nums.length; i++) {
			int left = Math.max(0, leftLower[i] + 1);
			int right = rightLower[i] == -1 ? nums.length : rightLower[i];

			java.math.BigInteger a = java.math.BigInteger.valueOf(nums[i]);
			java.math.BigInteger b = java.math.BigInteger.valueOf(prefixSum[right] - prefixSum[left]);

			max = max.max(a.multiply(b));
		}

		return max.mod(java.math.BigInteger.valueOf(1_000_000_007)).intValue();
	}

	public static void main(String[] args) {
		MaximumSubarrayMinProduct clazz = new MaximumSubarrayMinProduct();
		System.out.println(clazz.maxSumMinProduct(new int[]{3, 1, 5, 6, 4, 2}));
		System.out.println(clazz.maxSumMinProduct(new int[]{2, 5, 4, 2, 4, 5, 3, 1, 2, 4})); //50
		System.out.println(clazz.maxSumMinProduct(new int[]{1, 1, 3, 2, 2, 2, 1, 5, 1, 5})); //25
		System.out.println(clazz.maxSumMinProduct(new int[]{2, 3, 3, 1, 2}));
		System.out.println(clazz.maxSumMinProduct(new int[]{1, 2, 3, 2}));
	}
}
