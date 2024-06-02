package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.LinkedList;

/**
 * @author Ruslan Rakhmedov
 * @created 2024-06-01
 */
@LeetCode(
		id = 3170,
		name = "Lexicographically Minimum String After Removing Stars",
		url = "https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description/",
		difficulty = Difficulty.MEDIUM
)
public class LexicographicallyMinimumStringAfterRemovingStars {
	public String clearStars(String s) {
		char[] chars = s.toCharArray();
		LinkedList<Integer>[] positions = new LinkedList[26];
		for (int i = 0; i < 26; i++) {
			positions[i] = new LinkedList<>();
		}

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '*') {
				for (LinkedList pos : positions) {
					if (!pos.isEmpty()) {
						pos.removeLast();
						break;
					}
				}
			} else {
				positions[chars[i] - 'a'].add(i);
			}
		}

		return reconstruct(positions);
	}

	private String reconstruct(LinkedList<Integer>[] positions) {
		boolean seenChar = true;
		StringBuilder result = new StringBuilder();
		while (seenChar) {
			seenChar = false;
			int minPosList = -1;
			for (int i = 0; i < positions.length; i++) {
				LinkedList<Integer> pos = positions[i];
				seenChar = seenChar || !pos.isEmpty();
				if (!pos.isEmpty()) {
					if (minPosList == -1) {
						minPosList = i;
					} else {
						LinkedList<Integer> minList = positions[minPosList];
						if (pos.getFirst() < minList.getFirst()) {
							minPosList = i;
						}
					}
				}
			}

			if (minPosList != -1) {
				result.append((char) (minPosList + 'a'));
				positions[minPosList].removeFirst();
			}
		}

		return result.toString();
	}
}