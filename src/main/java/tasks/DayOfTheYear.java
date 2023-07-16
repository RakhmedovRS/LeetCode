package tasks;

import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-Jun-20
 */
@LeetCode(
		id = 1154,
		name = "Day of the Year",
		url = "https://leetcode.com/problems/day-of-the-year/submissions/",
		difficulty = Difficulty.EASY
)
public class DayOfTheYear
{
	public int dayOfYear(String date)
	{
		int[] daysPerMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] parts = date.split("-");
		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);
		int dayCount = 0;
		for (int i = 0; i < month - 1; i++)
		{
			dayCount += daysPerMonth[i];
		}
		dayCount += day;
		return isLeapYear(year) && month > 2 ? dayCount + 1 : dayCount;
	}

	private boolean isLeapYear(int year)
	{
		if (year % 4 != 0)
		{
			return false;
		}
		return year % 100 != 0 || year % 400 == 0;
	}

	public static void main(String[] args)
	{
		System.out.println(new DayOfTheYear().dayOfYear("2019-01-09"));
	}
}
