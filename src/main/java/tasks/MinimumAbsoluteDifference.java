package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 25-Mar-20
 */
@LeetCode(
		id = 1200,
		name = "Minimum Absolute Difference",
		url = "https://leetcode.com/problems/minimum-absolute-difference/",
		difficulty = Difficulty.EASY
)
public class MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(min, Math.abs(arr[i] - arr[i - 1]));
		}

		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) == min) {
				answer.add(Arrays.asList(arr[i - 1], arr[i]));
			}
		}

		return answer;
	}
}
