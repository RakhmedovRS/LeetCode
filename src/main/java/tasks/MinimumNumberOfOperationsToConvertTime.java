package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 4/16/2022
 */
@LeetCode(
		id = 2224,
		name = "Minimum Number of Operations to Convert Time",
		url = "https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/",
		difficulty = Difficulty.EASY
)
public class MinimumNumberOfOperationsToConvertTime {
	public int convertTime(String current, String correct) {
		int hours = (current.charAt(0) - '0') * 10 + (current.charAt(1) - '0');
		int minutes = (current.charAt(3) - '0') * 10 + (current.charAt(4) - '0');
		int currentTime = hours * 60 + minutes;

		hours = (correct.charAt(0) - '0') * 10 + (correct.charAt(1) - '0');
		minutes = (correct.charAt(3) - '0') * 10 + (correct.charAt(4) - '0');

		int correctTime = hours * 60 + minutes;

		int diff = Math.abs(currentTime - correctTime);

		int answer = 0;
		answer += diff / 60;
		diff %= 60;

		answer += diff / 15;
		diff %= 15;

		answer += diff / 5;
		diff %= 5;

		answer += diff;

		return answer;
	}
}
