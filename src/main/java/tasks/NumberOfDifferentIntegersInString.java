package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 3/28/2021
 */
@LeetCode(
		id = 1805,
		name = "Number of Different Integers in a String",
		url = "https://leetcode.com/problems/number-of-different-integers-in-a-string/",
		difficulty = Difficulty.EASY
)
public class NumberOfDifferentIntegersInString {
	public int numDifferentIntegers(String word) {
		Set<String> set = new HashSet<>();
		StringBuilder number = null;
		int digit;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isDigit(word.charAt(i))) {

				if (number == null) {
					number = new StringBuilder();
				}

				number.append(word.charAt(i) - '0');
			}
			else {
				if (number != null) {
					set.add(getActualNumber(number));
					number = null;
				}
			}
		}

		if (number != null) {
			set.add(getActualNumber(number));
		}

		return set.size();
	}

	private String getActualNumber(StringBuilder stringBuilder) {
		int i = 0;
		for (; i < stringBuilder.length() - 1; i++) {
			if (stringBuilder.charAt(i) != '0') {
				break;
			}
		}

		return stringBuilder.substring(i);
	}
}
