package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 26-Jun-20
 */
@LeetCode(id = 1447, name = "Simplified Fractions", url = "https://leetcode.com/problems/simplified-fractions/")
public class SimplifiedFractions {
	public List<String> simplifiedFractions(int n) {
		List<String> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			outer:
			for (int j = 1; j < i; j++) {
				for (int d = 2; d <= j; d++) {
					if (i % d == 0 && j % d == 0) {
						continue outer;
					}
				}

				answer.add(j + "/" + i);
			}
		}

		return answer;
	}
}
