package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 16-Jul-20
 */
@LeetCode(id = 507, name = "Perfect Number", url = "https://leetcode.com/problems/perfect-number/")
public class PerfectNumber {
	public boolean checkPerfectNumber(int num) {
		int sum = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				sum += i;
				if (i * i != num) {
					sum += num / i;
				}
			}
		}
		return sum - num == num;
	}

	public static void main(String[] args) {
		System.out.println(new PerfectNumber().checkPerfectNumber(99999997));
		System.out.println(new PerfectNumber().checkPerfectNumber(1));
		System.out.println(new PerfectNumber().checkPerfectNumber(100000000));
		System.out.println(new PerfectNumber().checkPerfectNumber(28));
	}
}
