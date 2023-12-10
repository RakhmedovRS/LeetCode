package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.TreeSet;

/**
 * @author RakhmedovRS
 * @created 2/26/2021
 */
@LeetCode(
		id = 775,
		name = "Global and Local Inversions",
		url = "https://leetcode.com/problems/global-and-local-inversions/",
		difficulty = Difficulty.MEDIUM
)
public class GlobalAndLocalInversions {
	public boolean isIdealPermutation(int[] A) {
		int global = 0;
		TreeSet<int[]> set = new TreeSet<>((a, b) ->
		{
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}

			return a[0] - b[0];
		});

		int[] arr;
		for (int i = A.length - 1; i >= 0; i--) {
			arr = new int[]{A[i], i};
			global += set.headSet(arr).size();
			set.add(arr);
		}

		int local = 0;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] > A[i + 1]) {
				local++;
			}
		}

		return global == local;
	}
}
