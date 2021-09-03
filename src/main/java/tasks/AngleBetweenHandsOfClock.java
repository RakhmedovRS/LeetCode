package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 14-Jul-20
 */
@LeetCode(
	id = 1344,
	name = "Angle Between Hands of a Clock",
	url = "https://leetcode.com/problems/angle-between-hands-of-a-clock/",
	difficulty = Difficulty.EASY
)
public class AngleBetweenHandsOfClock
{
	public double angleClock(int hour, int minutes)
	{
		double h = (hour + minutes / 60D) * 30 % 360;
		double m = minutes * 6;

		return Math.min(360 - Math.abs(h - m), Math.abs(h - m));
	}
}
