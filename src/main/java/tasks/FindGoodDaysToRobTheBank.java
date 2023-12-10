package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 12/11/2021
 */
@LeetCode(
		id = 2100,
		name = "Find Good Days to Rob the Bank",
		url = "https://leetcode.com/problems/find-good-days-to-rob-the-bank/",
		difficulty = Difficulty.MEDIUM
)
public class FindGoodDaysToRobTheBank {
	public List<Integer> goodDaysToRobBank(int[] security, int time) {
		List<Integer> answer = new ArrayList<>();

		int[] left = new int[security.length];
		for (int i = 1; i < left.length; i++) {
			if (security[i - 1] >= security[i]) {
				left[i] = left[i - 1] + 1;
			}
		}

		int[] right = new int[security.length];
		for (int i = security.length - 2; i >= 0; i--) {
			if (security[i + 1] >= security[i]) {
				right[i] = right[i + 1] + 1;
			}
		}

		for (int i = 0; i < security.length; i++) {
			if (left[i] >= time && right[i] >= time) {
				answer.add(i);
			}
		}

		return answer;
	}
}
