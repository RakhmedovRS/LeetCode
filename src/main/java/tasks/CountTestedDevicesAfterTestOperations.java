package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author Ruslan Rakhmedov
 * @created 12/10/2023
 */
@LeetCode(
		id = 2960,
		name = "Count Tested Devices After Test Operations",
		url = "https://leetcode.com/problems/count-tested-devices-after-test-operations/",
		difficulty = Difficulty.EASY
)
public class CountTestedDevicesAfterTestOperations {
	public int countTestedDevices(int[] batteryPercentages) {
		int ans = 0;
		int balance = 0;
		for (int i = 0; i < batteryPercentages.length; i++) {
			if (batteryPercentages[i] + balance > 0) {
				ans++;
				balance--;
			}
		}

		return ans;
	}
}
