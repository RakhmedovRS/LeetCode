package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 02-Jun-20
 */
@LeetCode(id = 1464, name = "Maximum Product of Two Elements in an Array", url = "https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/")
public class MaximumProductOfTwoElementsInAnArray {
	public int maxProduct(int[] nums) {
		int a = Integer.MIN_VALUE;
		int b = Integer.MIN_VALUE;
		for (int num : nums) {
			if (num > a) {
				b = a;
				a = num;
			}
			else if (num > b) {
				b = num;
			}
		}

		return (a - 1) * (b - 1);
	}
}
