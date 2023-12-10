package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 7/25/2021
 */
@LeetCode(
		id = 1947,
		name = "Maximum Compatibility Score Sum",
		url = "https://leetcode.com/problems/maximum-compatibility-score-sum/",
		difficulty = Difficulty.MEDIUM
)
public class MaximumCompatibilityScoreSum {
	public int maxCompatibilitySum(int[][] students, int[][] mentors) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < students.length + mentors.length; i++) {
			sb.append('1');
		}

		char[] state = new char[students.length + mentors.length];
		Arrays.fill(state, '0');

		return dfs(state, new HashMap<>(), students, mentors, sb.toString());
	}

	private int dfs(char[] state, Map<String, Integer> memo, int[][] students, int[][] mentors, String endState) {
		String currentState = String.valueOf(state);
		if (currentState.equals(endState)) {
			return 0;
		}

		if (memo.containsKey(currentState)) {
			return memo.get(currentState);
		}

		int max = 0;
		for (int i = 0; i < students.length; i++) {
			if (state[i] == '1') {
				continue;
			}

			state[i] = '1';

			for (int j = 0; j < students.length; j++) {
				if (state[j + students.length] == '1') {
					continue;
				}

				int sum = 0;
				state[j + students.length] = '1';

				for (int x = 0; x < students[i].length; x++) {
					if (students[i][x] == mentors[j][x]) {
						sum++;
					}
				}

				max = Math.max(max, sum + dfs(state, memo, students, mentors, endState));
				state[j + students.length] = '0';
			}

			state[i] = '0';
		}

		memo.put(currentState, max);

		return max;
	}
}
