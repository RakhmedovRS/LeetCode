package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/25/2022
 */
@LeetCode(
		id = 2315,
		name = "Count Asterisks",
		url = "https://leetcode.com/problems/count-asterisks/",
		difficulty = Difficulty.EASY
)
public class CountAsterisks {
	public int countAsterisks(String s) {
		int answer = 0;
		int count = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '|') {
				count++;
				count %= 2;
			}
			else if (ch == '*' && count == 0) {
				answer++;
			}
		}


		return answer;
	}
}
