package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ruslan Rakhmedov
 * @created 2/7/2023
 */
@LeetCode(
		id = 2553,
		name = "Separate the Digits in an Array",
		url = "https://leetcode.com/problems/separate-the-digits-in-an-array/",
		difficulty = Difficulty.EASY
)
public class SeparateTheDigitsInArray {
	public int[] separateDigits(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			char[] chars = (num + "").toCharArray();
			for (char ch : chars) {
				list.add(ch - '0');
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
