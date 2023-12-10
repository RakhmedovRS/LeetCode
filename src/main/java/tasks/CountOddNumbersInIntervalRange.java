package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 25-Jul-20
 */
@LeetCode(
		id = 1523,
		name = "Count Odd Numbers in an Interval Range",
		url = "https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/",
		difficulty = Difficulty.EASY
)
public class CountOddNumbersInIntervalRange {
	public int countOdds(int low, int high) {
		int add = (low % 2 != 0 || high % 2 != 0) ? 1 : 0;
		return (high - low) / 2 + add;
	}
}
