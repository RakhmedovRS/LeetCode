package tasks;

import common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author RakhmedovRS
 * @created 22-May-20
 */
@LeetCode(id = 1390, name = "Four Divisors", url = "https://leetcode.com/problems/four-divisors/")
public class FourDivisors {
	public int sumFourDivisors(int[] nums) {
		int totalSum = 0;
		int sum;
		int dividers;
		Map<Integer, Integer> memo = new HashMap<>();
		for (int number : nums) {
			if (memo.containsKey(number)) {
				totalSum += memo.get(number);
				continue;
			}

			dividers = 0;
			sum = 0;
			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					dividers++;
					sum += i;
				}

				if (dividers > 4) {
					break;
				}
			}
			if (dividers == 4) {
				memo.put(number, sum);
				totalSum += sum;
			}
			else {
				memo.put(number, 0);
			}
		}

		return totalSum;
	}
}
