package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author Ruslan Rakhmedov
 * @created 12/16/2023
 */
@LeetCode(
		id = 2967,
		name = "Minimum Cost to Make Array Equalindromic",
		url = "https://leetcode.com/problems/minimum-cost-to-make-array-equalindromic/description/",
		difficulty = Difficulty.MEDIUM
)
public class MinimumCostToMakeArrayEqualindromic {
	public long minimumCost(int[] nums) {
		Arrays.sort(nums);
		int median = nums[nums.length / 2];
		int smallerPalindrome = smaller(median);
		int biggerPalindrome = bigger(median);

		long resForSmaller = 0;
		long resForBigger = 0;

		for (int num : nums) {
			resForSmaller += Math.abs(smallerPalindrome - num);
			resForBigger += Math.abs(biggerPalindrome - num);
		}

		return Math.min(resForSmaller, resForBigger);
	}

	private int smaller(int median) {
		while (!isPalindrome(median)) {
			median--;
		}

		return median;
	}

	private int bigger(int median) {
		while (!isPalindrome(median)) {
			median++;
		}

		return median;
	}

	public static boolean isPalindrome(long num) {
		long temp = num;
		long reversed = 0;
		while (temp > 0) {
			reversed *= 10;
			reversed += temp % 10;
			temp /= 10;
		}

		return reversed == num;
	}
}
