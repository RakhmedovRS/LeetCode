package tasks;

import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 02-Apr-20
 */
@LeetCode(id = 202, name = "Happy Number", url = "https://leetcode.com/problems/happy-number/")
public class HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> values = new HashSet<>();
		values.add(n);

		int nextValue = n;
		while (true) {
			nextValue = calcNextNumber(nextValue);
			if (nextValue == 1) {
				return true;
			}
			else {
				if (!values.add(nextValue)) {
					return false;
				}
			}
		}
	}

	private int calcNextNumber(int number) {
		int res = 0;
		while (number > 0) {
			int num = number % 10;
			if (num > 0) {
				res += Math.pow(num, 2);
			}
			number /= 10;
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(new HappyNumber().isHappy(6));
		System.out.println(new HappyNumber().isHappy(19));
	}
}
