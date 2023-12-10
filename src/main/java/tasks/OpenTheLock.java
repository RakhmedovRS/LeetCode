package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.*;

/**
 * @author RakhmedovRS
 * @created 07-Aug-20
 */
@LeetCode(
		id = 752,
		name = "Open the Lock",
		url = "https://leetcode.com/problems/open-the-lock/",
		difficulty = Difficulty.MEDIUM
)
public class OpenTheLock {
	public int openLock(String[] deadends, String target) {
		Set<String> visited = new HashSet<>(Arrays.asList(deadends));

		Queue<String> queue = new LinkedList<>();
		queue.add("0000");
		int size;
		int steps = 0;
		String current;
		char[] chars;
		while (!queue.isEmpty()) {
			size = queue.size();
			while (size-- > 0) {
				current = queue.remove();
				if (!visited.add(current)) {
					continue;
				}

				if (current.equals(target)) {
					return steps;
				}

				chars = current.toCharArray();
				char original;
				for (int i = 0; i < chars.length; i++) {
					original = chars[i];

					chars[i] = chars[i] == '9' ? '0' : (char) (chars[i] + 1);
					if (!visited.contains(String.valueOf(chars))) {
						queue.add(String.valueOf(chars));
					}

					chars[i] = original;

					chars[i] = chars[i] == '0' ? '9' : (char) (chars[i] - 1);
					if (!visited.contains(String.valueOf(chars))) {
						queue.add(String.valueOf(chars));
					}

					chars[i] = original;
				}
			}

			steps++;
		}

		return -1;
	}
}
