package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author RakhmedovRS
 * @created 02-Jul-20
 */
@LeetCode(
		id = 739,
		name = "Daily Temperatures",
		url = "https://leetcode.com/problems/daily-temperatures/",
		difficulty = Difficulty.MEDIUM
)
public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] answer = new int[temperatures.length];
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < temperatures.length; i++) {
			while (!list.isEmpty() && temperatures[i] > temperatures[list.getLast()]) {
				int prev = list.removeLast();
				answer[prev] = i - prev;
			}

			list.addLast(i);
		}

		return answer;
	}
}
