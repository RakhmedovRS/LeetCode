import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/13/2020
 */
@LeetCode(
	id = 1118,
	name = "Number of Days in a Month",
	url = "https://leetcode.com/problems/number-of-days-in-a-month/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class NumberOfDaysInMonth
{
	public int numberOfDays(int Y, int M)
	{
		return java.time.YearMonth.of(Y, M).lengthOfMonth();
	}
}
