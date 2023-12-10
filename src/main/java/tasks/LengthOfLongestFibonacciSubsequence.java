package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 20-May-20
 */
@LeetCode(
		id = 873,
		name = "Length of Longest Fibonacci Subsequence",
		url = "https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/",
		difficulty = Difficulty.MEDIUM
)
public class LengthOfLongestFibonacciSubsequence {
	public int lenLongestFibSubseq(int[] A) {
		int max = 0;
		Set<Integer> set = new HashSet<>();
		for (int number : A) {
			set.add(number);
		}

		for (int left = 0; left < A.length; left++) {
			for (int right = left + 1; right < A.length; right++) {
				int length = 2;
				int x = A[left];
				int y = A[right];
				while (set.contains(x + y)) {
					int temp = x + y;
					x = y;
					y = temp;
					length++;
				}

				if (length > max) {
					max = length;
				}
			}
		}

		return max < 3 ? 0 : max;
	}
}
