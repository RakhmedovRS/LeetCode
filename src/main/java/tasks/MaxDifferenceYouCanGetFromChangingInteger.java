package tasks;

import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 04-Jul-20
 */
@LeetCode(id = 1432, name = "Max Difference You Can Get From Changing an Integer", url = "https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/")
public class MaxDifferenceYouCanGetFromChangingInteger {
	public int maxDiff(int num) {
		char[] number = String.valueOf(num).toCharArray();
		char[] max = increase(number);
		char[] min = decrease(number);

		return Integer.parseInt(String.valueOf(max)) - Integer.parseInt(String.valueOf(min));
	}

	private char[] increase(char[] number) {
		char[] max = new char[number.length];
		int pos = 0;
		while (pos < number.length && number[pos] == '9') {
			max[pos++] = '9';
		}

		if (pos < number.length) {
			char ch = number[pos];
			for (; pos < number.length; pos++) {
				if (number[pos] == ch) {
					max[pos] = '9';
				}
				else {
					max[pos] = number[pos];
				}
			}
		}

		return max;
	}

	private char[] decrease(char[] number) {
		if (containsRepetitiveDigit(number)) {
			char[] min = new char[number.length];
			Arrays.fill(min, '1');
			return min;
		}

		char[] min = Arrays.copyOf(number, number.length);

		if (min[0] == '1') {
			int pos = 1;
			while (pos < number.length && (number[pos] == '0' || number[pos] == '1')) {
				pos++;
			}

			if (pos < number.length) {
				char ch = min[pos];
				for (; pos < number.length; pos++) {
					if (min[pos] == ch) {
						min[pos] = '0';
					}
				}
			}
		}
		else {
			char ch = min[0];
			for (int i = 0; i < number.length; i++) {
				if (min[i] == ch) {
					min[i] = '1';
				}
			}
		}

		return min;
	}

	private boolean containsRepetitiveDigit(char[] number) {
		int pos = 0;
		while (pos < number.length && number[pos] == number[0]) {
			pos++;
		}

		return pos == number.length;
	}

	public static void main(String[] args) {
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(1101057));
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(111));
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(9));
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(10000));
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(9288));
		System.out.println(new MaxDifferenceYouCanGetFromChangingInteger().maxDiff(123456));
	}
}
