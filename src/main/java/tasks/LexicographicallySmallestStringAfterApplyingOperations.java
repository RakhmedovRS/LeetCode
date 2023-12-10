package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 10/18/2020
 */
@LeetCode(id = 1625, name = "Lexicographically Smallest String After Applying Operations", url = "https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/")
public class LexicographicallySmallestStringAfterApplyingOperations {
	public String findLexSmallestString(String s, int a, int b) {
		String smallest = s;
		char[] chars = s.toCharArray();
		Set<String> seen = new HashSet<>();
		Queue<char[]> queue = new LinkedList<>();
		queue.add(chars);
		char[] current;
		String string;
		while (!queue.isEmpty()) {
			current = queue.remove();
			string = String.valueOf(current);
			if (!seen.add(string)) {
				continue;
			}

			if (string.compareTo(smallest) < 0) {
				smallest = string;
			}

			queue.add(rotate(current, b));
			add(current, a);
			queue.add(current);
		}

		return smallest;
	}

	private char[] rotate(char[] chars, int b) {
		char[] rotated = new char[chars.length];
		int startPos = chars.length - b;
		int current = startPos;
		int pos = 0;
		do {
			rotated[pos++] = chars[current++ % chars.length];
		}
		while (startPos != current % chars.length);

		return rotated;
	}

	private void add(char[] chars, int a) {
		int val;
		for (int i = 1; i < chars.length; i += 2) {
			val = chars[i] - '0';
			val = (val + a) % 10;
			chars[i] = (char) (val + '0');
		}
	}

	public static void main(String[] args) {

		System.out.println(new LexicographicallySmallestStringAfterApplyingOperations().findLexSmallestString("192804", 8, 5));
		System.out.println(new LexicographicallySmallestStringAfterApplyingOperations().findLexSmallestString("74", 5, 1));
		System.out.println(new LexicographicallySmallestStringAfterApplyingOperations().findLexSmallestString("43987654", 7, 3));
		System.out.println(new LexicographicallySmallestStringAfterApplyingOperations().findLexSmallestString("5525", 9, 2));
	}
}
