package tasks;

import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 18.06.2020
 */
@LeetCode(id = 1291, name = "Sequential Digits", url = "https://leetcode.com/problems/sequential-digits/")
public class SequentialDigits {
	public List<Integer> sequentialDigits(int low, int high) {
		List<Integer> answer = new ArrayList<>();
		int lowLength = getLength(low);
		int highLength = getLength(high);
		while (lowLength <= highLength) {
			int factor = (int) Math.pow(10, lowLength - 1);
			int value = 0;
			for (int i = 1; i <= lowLength; i++) {
				value *= 10;
				value += i;
			}

			for (int i = lowLength + 1; i <= 10; i++) {
				if (value >= low && value <= high) {
					answer.add(value);
				}
				value *= 10;
				value += i;
				value %= (factor * 10);
			}

			lowLength++;
		}

		return answer;
	}

	private int getLength(int num) {
		int length = 0;
		while (num > 0) {
			length++;
			num /= 10;
		}

		return length;
	}
}
