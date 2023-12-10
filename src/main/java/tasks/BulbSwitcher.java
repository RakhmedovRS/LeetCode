package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 29-Feb-20
 */
@LeetCode(id = 319, name = "Bulb Switcher", url = "https://leetcode.com/problems/bulb-switcher/")
public class BulbSwitcher {
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) {
		System.out.println(new BulbSwitcher().bulbSwitch(4));
	}
}
