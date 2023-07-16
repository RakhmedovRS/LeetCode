package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.PriorityQueue;

/**
 * @author RakhmedovRS
 * @created 5/1/2021
 */
@LeetCode(
		id = 1845,
		name = "Seat Reservation Manager",
		url = "https://leetcode.com/problems/seat-reservation-manager/",
		difficulty = Difficulty.MEDIUM
)
public class SeatReservationManager
{
	class SeatManager
	{

		PriorityQueue<Integer> seats;

		public SeatManager(int n)
		{
			seats = new PriorityQueue<>();
			for (int i = 1; i <= n; i++)
			{
				seats.add(i);
			}
		}

		public int reserve()
		{
			return seats.remove();
		}

		public void unreserve(int seatNumber)
		{
			seats.add(seatNumber);
		}
	}
}
