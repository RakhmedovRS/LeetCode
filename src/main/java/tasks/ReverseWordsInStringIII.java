package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 557, name = "Reverse Words in a String III", url = "https://leetcode.com/problems/reverse-words-in-a-string-iii/")
public class ReverseWordsInStringIII {
	public String reverseWords(String s) {
		if (s == null || s.isEmpty()) {
			return s;
		}

		List<String> words = new ArrayList<>();
		for (String word : s.split(" ")) {
			if (!word.isEmpty()) {
				words.add(reverseWord(word));
			}
		}

		return String.join(" ", words);
	}

	private String reverseWord(String word) {
		char[] chars = word.toCharArray();
		int left = 0;
		int right = chars.length - 1;
		while (left < right) {
			char temp = chars[left];
			chars[left] = chars[right];
			chars[right] = temp;

			left++;
			right--;
		}

		return String.valueOf(chars);
	}

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInStringIII().reverseWords("I love you"));
		System.out.println(new ReverseWordsInStringIII().reverseWords("Let's take LeetCode contest"));
	}
}
