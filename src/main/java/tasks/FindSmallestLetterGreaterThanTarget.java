package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Jun-20
 */
@LeetCode(id = 744, name = "Find Smallest Letter Greater Than Target", url = "https://leetcode.com/problems/find-smallest-letter-greater-than-target/")
public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		boolean[] seen = new boolean[26];
		for (char c : letters) {
			seen[c - 'a'] = true;
		}

		while (true) {
			target++;
			if (target > 'z') {
				target = 'a';
			}
			if (seen[target - 'a']) {
				return target;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
		System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
		System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
	}
}
