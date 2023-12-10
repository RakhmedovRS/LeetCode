package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 11/4/2020
 */
@LeetCode(
		id = 1023,
		name = "Camelcase Matching",
		url = "https://leetcode.com/problems/camelcase-matching/",
		difficulty = Difficulty.MEDIUM
)
public class CamelcaseMatching {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> answer = new ArrayList<>(queries.length);
		for (String query : queries) {
			answer.add(isMatch(query, pattern));
		}
		return answer;
	}

	private boolean isMatch(String string, String pattern) {
		int patternPos = 0;
		for (int i = 0; i < string.length(); i++) {
			if (Character.isUpperCase(string.charAt(i))) {
				if (patternPos == pattern.length() || string.charAt(i) != pattern.charAt(patternPos++)) {
					return false;
				}
			}
			else if (patternPos != pattern.length() && string.charAt(i) == pattern.charAt(patternPos)) {
				patternPos++;
			}
		}

		return patternPos == pattern.length();
	}

	public static void main(String[] args) {
		System.out.println(new CamelcaseMatching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FB"));
		System.out.println(new CamelcaseMatching().camelMatch(new String[]{"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, "FoBa"));
	}
}
