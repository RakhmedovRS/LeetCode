package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 17-Sep-20
 */
@LeetCode(id = 1227, name = "Airplane Seat Assignment Probability", url = "https://leetcode.com/problems/airplane-seat-assignment-probability/")
public class AirplaneSeatAssignmentProbability
{
	public double nthPersonGetsNthSeat(int n)
	{
		return n == 0 ? 0 : n == 1 ? 1D : 0.5D;
	}
}
