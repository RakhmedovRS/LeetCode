package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(
		id = 151,
		name = "Reverse Words in a String",
		url = "https://leetcode.com/problems/reverse-words-in-a-string/",
		difficulty = Difficulty.MEDIUM
)
public class ReverseWordsInString {
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder(words.length);
		for (int i = words.length - 1; i >= 0; i--) {
			if (words[i].length() != 0) {
				if (result.length() != 0) {
					result.append(" ");
				}
				result.append(words[i]);
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ReverseWordsInString().reverseWords(""));
		System.out.println(new ReverseWordsInString().reverseWords(" "));
		System.out.println(new ReverseWordsInString().reverseWords("the sky is blue"));
		System.out.println(new ReverseWordsInString().reverseWords("  hello world!  "));
	}
}
