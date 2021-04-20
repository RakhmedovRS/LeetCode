package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 28-May-20
 */
@LeetCode(id = 1360, name = "Number of Days Between Two Dates", url = "https://leetcode.com/problems/number-of-days-between-two-dates/")
public class NumberOfDaysBetweenTwoDates
{
	public int daysBetweenDates(String date1, String date2)
	{
		java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
		java.time.LocalDate localDate1 = java.time.LocalDate.parse(date1, formatter);
		java.time.LocalDate localDate2 = java.time.LocalDate.parse(date2, formatter);

		return (int) Math.abs(java.time.temporal.ChronoUnit.DAYS.between(localDate1, localDate2));
	}
}
