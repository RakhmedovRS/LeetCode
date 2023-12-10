package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 6/10/2023
 */
@LeetCode(
		id = 2730,
		name = "Find the Longest Semi-Repetitive Substring",
		url = "https://leetcode.com/problems/find-the-longest-semi-repetitive-substring/",
		difficulty = Difficulty.MEDIUM
)
public class FindTheLongestSemiRepetitiveSubstring {
	public int longestSemiRepetitiveSubstring(String s) {
		int max = 0;
		outer:
		for (int i = 0; i < s.length(); i++) {
			boolean seen = false;
			LinkedList<Character> list = new LinkedList<>();
			for (int j = i; j < s.length(); j++) {
				if (list.isEmpty()) {
					list.addLast(s.charAt(j));
				}
				else {
					if (list.getLast().equals(s.charAt(j))) {
						if (seen) {
							continue outer;
						}

						seen = true;

						char tmp = list.removeLast();
						if (list.isEmpty() || !list.getLast().equals(s.charAt(j))) {
							list.addLast(tmp);
							list.addLast(s.charAt(j));
						}
						else {
							continue outer;
						}
					}
					else {
						list.addLast(s.charAt(j));
					}
				}

				max = Math.max(max, list.size());
			}

		}

		return max;
	}
}
