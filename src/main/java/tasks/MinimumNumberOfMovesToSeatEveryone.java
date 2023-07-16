package tasks;

import common.Difficulty;
import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 10/16/2021
 */
@LeetCode(
		id = 2037,
		name = "Minimum Number of Moves to Seat Everyone",
		url = "https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/",
		difficulty = Difficulty.EASY
)
public class MinimumNumberOfMovesToSeatEveryone
{
	public int minMovesToSeat(int[] seats, int[] students)
	{
		int moves = 0;
		Arrays.sort(seats);
		Arrays.sort(students);

		for (int i = 0; i < seats.length; i++)
		{
			moves += Math.abs(seats[i] - students[i]);
		}

		return moves;
	}
}
