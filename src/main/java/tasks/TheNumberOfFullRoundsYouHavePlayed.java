package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 6/20/2021
 */
@LeetCode(
	id = 1904,
	name = "The Number of Full Rounds You Have Played",
	url = "https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/",
	difficulty = Difficulty.MEDIUM
)
public class TheNumberOfFullRoundsYouHavePlayed
{
	public int numberOfRounds(String startTime, String finishTime)
	{
		int rounds = 0;
		int startHours = Integer.parseInt(startTime.substring(0, 2));
		int startMinutes = Integer.parseInt(startTime.substring(3, 5));
		int finishHours = Integer.parseInt(finishTime.substring(0, 2));
		int finishMinutes = Integer.parseInt(finishTime.substring(3, 5));

		boolean overnight = startHours > finishHours || (startHours == finishHours && startMinutes > finishMinutes);

		if (startMinutes > 0 && startMinutes <= 15)
		{
			startMinutes = 15;
		}
		else if (startMinutes > 15 && startMinutes <= 30)
		{
			startMinutes = 30;
		}
		else if (startMinutes > 30 && startMinutes <= 45)
		{
			startMinutes = 45;
		}
		else if (startMinutes > 45)
		{
			startMinutes = 0;
			if (startHours == 23 && !overnight)
			{
				return 0;
			}
			startHours++;
		}

		while (overnight || startHours <= finishHours)
		{
			startMinutes += 15;
			if (startMinutes == 60)
			{
				startHours++;
				startMinutes = 0;
			}

			if (startHours == 24 && overnight)
			{
				startHours = 0;
				overnight = false;
			}

			if (overnight || startHours < finishHours || startHours == finishHours && startMinutes <= finishMinutes)
			{
				rounds++;
			}

			if (!overnight && startHours == finishHours && startMinutes >= finishMinutes)
			{
				break;
			}
		}

		return rounds;
	}

	public static void main(String[] args)
	{
		TheNumberOfFullRoundsYouHavePlayed clazz = new TheNumberOfFullRoundsYouHavePlayed();
		System.out.println(clazz.numberOfRounds("12:01", "12:02"));
	}
}
