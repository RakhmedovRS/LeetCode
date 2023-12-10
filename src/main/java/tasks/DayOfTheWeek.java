package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 30-May-20
 */
@LeetCode(id = 1185, name = "Day of the Week", url = "https://leetcode.com/problems/day-of-the-week/")
public class DayOfTheWeek {
	public String dayOfTheWeek(int day, int month, int year) {
		java.time.LocalDate localDate = java.time.LocalDate.of(year, month, day);
		return localDate.getDayOfWeek().getDisplayName(java.time.format.TextStyle.FULL_STANDALONE, java.util.Locale.ENGLISH);
	}

	public static void main(String[] args) {
		System.out.println(new DayOfTheWeek().dayOfTheWeek(31, 8, 2019));
	}
}
