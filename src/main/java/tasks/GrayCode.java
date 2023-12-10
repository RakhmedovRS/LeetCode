package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 7/1/2021
 */
@LeetCode(
		id = 89,
		name = "Gray Code",
		url = "https://leetcode.com/problems/gray-code/",
		difficulty = Difficulty.MEDIUM
)
public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new LinkedList<>();
		for (int i = 0; i < 1 << n; i++) {
			result.add(i ^ (i >> 1));
		}
		return result;
	}
}
