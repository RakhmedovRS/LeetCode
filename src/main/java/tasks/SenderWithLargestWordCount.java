package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 6/12/2022
 */
@LeetCode(
		id = 2284,
		name = "Sender With Largest Word Count",
		url = "https://leetcode.com/problems/sender-with-largest-word-count/",
		difficulty = Difficulty.MEDIUM
)
public class SenderWithLargestWordCount {
	public String largestWordCount(String[] messages, String[] senders) {
		Map<String, Integer> map = new HashMap<>();
		int max = 0;
		for (int i = 0; i < senders.length; i++) {
			map.put(senders[i], map.getOrDefault(senders[i], 0) + messages[i].split(" ").length);
			max = Math.max(max, map.get(senders[i]));
		}

		String answer = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == max && entry.getKey().compareTo(answer) > 0) {
				answer = entry.getKey();
			}
		}

		return answer;
	}
}
