package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @version 1.0
 * @since 10.03.2021
 */
@LeetCode(
		id = 636,
		name = "Exclusive Time of Functions",
		url = "https://leetcode.com/problems/exclusive-time-of-functions/",
		difficulty = Difficulty.MEDIUM
)
public class ExclusiveTimeOfFunctions {
	public int[] exclusiveTime(int n, List<String> logs) {
		int[] answer = new int[n];
		Deque<Integer> deque = new LinkedList<>();
		String[] parts;
		int currentTime = 0;
		int id;
		String command;
		int timeStamp;
		for (String log : logs) {
			parts = log.split(":");
			id = Integer.parseInt(parts[0]);
			command = parts[1];
			timeStamp = Integer.parseInt(parts[2]);

			if (command.equals("start")) {
				if (!deque.isEmpty()) {
					answer[deque.peek()] += timeStamp - currentTime;
					currentTime = timeStamp;
				}
				deque.push(id);
			}
			else {
				answer[deque.pop()] += (timeStamp + 1) - currentTime;
				currentTime = timeStamp + 1;
			}
		}

		return answer;
	}
}
