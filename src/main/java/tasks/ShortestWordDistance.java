package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/1/2020
 */
@LeetCode(
		id = 243,
		name = "Shortest Word Distance",
		url = "https://leetcode.com/problems/shortest-word-distance/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int distance = Integer.MAX_VALUE;
		Integer lastIndexOfWord1 = null;
		Integer lastIndexOfWord2 = null;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				lastIndexOfWord1 = i;
			}

			if (words[i].equals(word2)) {
				lastIndexOfWord2 = i;
			}

			if (lastIndexOfWord1 != null && lastIndexOfWord2 != null) {
				distance = Math.min(distance, Math.abs(lastIndexOfWord1 - lastIndexOfWord2));
			}
		}

		return distance;
	}
}
