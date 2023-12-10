package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 04-Apr-20
 */
@LeetCode(id = 371, name = "Sum of Two Integers", url = "https://leetcode.com/problems/sum-of-two-integers/")
public class SumOfTwoIntegers {
	public int getSum(int a, int b) {
		int carry;
		while (b != 0) {
			carry = (a & b);
			a = a ^ b;
			b = (carry) << 1;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(new SumOfTwoIntegers().getSum(10, 7));
	}
}
