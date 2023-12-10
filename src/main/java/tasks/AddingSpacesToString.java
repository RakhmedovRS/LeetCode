package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 12/19/2021
 */
@LeetCode(
		id = 2109,
		name = "Adding Spaces to a String",
		url = "https://leetcode.com/problems/adding-spaces-to-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class AddingSpacesToString {
	public String addSpaces(String s, int[] spaces) {
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		for (int i : spaces) {
			set.add(i);
		}

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(i)) {
				sb.append(" ");
			}
			sb.append(s.charAt(i));
		}

		return sb.toString();
	}
}
