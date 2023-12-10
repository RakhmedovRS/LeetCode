package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/26/2021
 */
@LeetCode(
		id = 1910,
		name = "Remove All Occurrences of a Substring",
		url = "https://leetcode.com/problems/remove-all-occurrences-of-a-substring/",
		difficulty = Difficulty.MEDIUM
)
public class RemoveAllOccurrencesOfSubstring {
	public String removeOccurrences(String s, String part) {
		int index = s.indexOf(part);
		while (index != -1) {
			s = s.substring(0, index) + s.substring(index + part.length());
			index = s.indexOf(part);
		}

		return s;
	}
}
