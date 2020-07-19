import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 19-Jul-20
 */
@LeetCode(id = 1109, name = "Corporate Flight Bookings", url = "https://leetcode.com/problems/corporate-flight-bookings/")
public class CorporateFlightBookings
{
	public int[] corpFlightBookings(int[][] bookings, int n)
	{
		int[] answer = new int[n];
		for (int[] booking : bookings)
		{
			answer[booking[0] - 1] += booking[2];
			if (booking[1] < n)
			{
				answer[booking[1]] -= booking[2];
			}
		}

		for (int i = 1; i < n; i++)
		{
			answer[i] += answer[i - 1];
		}

		return answer;
	}
}
