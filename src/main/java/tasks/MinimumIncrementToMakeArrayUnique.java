package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 30-Jun-20
 */
@LeetCode(id = 945, name = "Minimum Increment to Make Array Unique", url = "https://leetcode.com/problems/minimum-increment-to-make-array-unique/")
public class MinimumIncrementToMakeArrayUnique {
	public int minIncrementForUnique(int[] A) {
		Arrays.sort(A);
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			if (A[i - 1] >= A[i]) {
				count += A[i - 1] - A[i] + 1;
				A[i] = A[i - 1] + 1;
			}
		}
		return count;
	}
}
