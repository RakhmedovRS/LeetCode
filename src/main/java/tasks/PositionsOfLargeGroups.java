package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 23-Jul-20
 */
@LeetCode(id = 830, name = "Positions of Large Groups", url = "https://leetcode.com/problems/positions-of-large-groups/")
public class PositionsOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
		if (S == null || S.length() < 3) {
			return new ArrayList<>();
		}

		char prev = S.charAt(0);
		int prevIndex = 0;
		List<List<Integer>> answer = new ArrayList<>();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) != prev) {
				if (i - 1 - prevIndex >= 2) {
					answer.add(Arrays.asList(prevIndex, i - 1));
				}
				prev = S.charAt(i);
				prevIndex = i;
			}
		}

		if (S.length() - 1 - prevIndex >= 2) {
			answer.add(Arrays.asList(prevIndex, S.length() - 1));
		}

		return answer;
	}
}
