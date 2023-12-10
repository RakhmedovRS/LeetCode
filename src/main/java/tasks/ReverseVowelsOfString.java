package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 11-Apr-20
 */
@LeetCode(id = 345, name = "Reverse Vowels of a String", url = "https://leetcode.com/problems/reverse-vowels-of-a-string/")
public class ReverseVowelsOfString {
	public String reverseVowels(String s) {
		if (s == null || s.length() <= 0) {
			return s;
		}

		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('A');
		vowels.add('e');
		vowels.add('E');
		vowels.add('i');
		vowels.add('I');
		vowels.add('o');
		vowels.add('O');
		vowels.add('u');
		vowels.add('U');

		int leftVowel = 0;
		int rightVowel = s.length() - 1;
		char[] chars = s.toCharArray();
		while (leftVowel < rightVowel) {
			while (leftVowel < chars.length && !vowels.contains(chars[leftVowel])) {
				leftVowel++;
			}
			if (leftVowel == chars.length - 1 || leftVowel >= rightVowel) {
				break;
			}

			while (rightVowel >= 0 && !vowels.contains(chars[rightVowel])) {
				rightVowel--;
			}

			char temp = chars[leftVowel];
			chars[leftVowel] = chars[rightVowel];
			chars[rightVowel] = temp;
			leftVowel++;
			rightVowel--;
		}

		return new String(chars);
	}

	public static void main(String[] args) {
		System.out.println(new ReverseVowelsOfString().reverseVowels("aA"));
		System.out.println(new ReverseVowelsOfString().reverseVowels("hello"));
		System.out.println(new ReverseVowelsOfString().reverseVowels("leetcode"));
	}
}
