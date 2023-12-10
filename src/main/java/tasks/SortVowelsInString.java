package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ruslan Rakhmedov
 * @created 7/22/2023
 */
@LeetCode(
		id = 2785,
		name = "Sort Vowels in a String",
		url = "https://leetcode.com/problems/sort-vowels-in-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class SortVowelsInString {
	public String sortVowels(String s) {
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');

		char[] chars = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for (char ch : chars) {
			if (vowels.contains(ch)) {
				list.add(ch);
			}
		}

		list.sort(null);

		for (int i = 0, j = 0; i < chars.length; i++) {
			if (vowels.contains(chars[i])) {
				chars[i] = list.get(j++);
			}
		}

		return String.valueOf(chars);
	}
}
