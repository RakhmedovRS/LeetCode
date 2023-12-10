package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/30/2020
 */
@LeetCode(
		id = 604,
		name = "Design Compressed String Iterator",
		url = "https://leetcode.com/problems/design-compressed-string-iterator/",
		difficulty = Difficulty.EASY,
		premium = true
)
public class DesignCompressedStringIterator {
	class StringIterator {
		char[] chars;
		int pos;
		char current;
		int count;

		public StringIterator(String compressedString) {
			chars = compressedString.toCharArray();
		}

		public char next() {
			if (count == 0) {
				if (pos == chars.length) {
					return ' ';
				}

				current = chars[pos++];
				while (pos < chars.length && Character.isDigit(chars[pos])) {
					count *= 10;
					count += chars[pos++] - '0';
				}
			}

			count--;
			return current;
		}

		public boolean hasNext() {
			return count > 0 || pos < chars.length;
		}
	}

	public static void main(String[] args) {
		StringIterator stringIterator = new DesignCompressedStringIterator().new StringIterator("x6");
		stringIterator.next();
		stringIterator.next();
		stringIterator.next();
		System.out.println(stringIterator.hasNext());
		stringIterator.next();
		stringIterator.next();
		stringIterator.next();

	}
}
