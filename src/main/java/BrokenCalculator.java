import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Sep-20
 */
@LeetCode(id = 991, name = "Broken Calculator", url = "https://leetcode.com/problems/broken-calculator/")
public class BrokenCalculator
{
	public int brokenCalc(int current, int target)
	{
		int ops = 0;
		while (target > current)
		{
			ops++;
			if (target % 2 == 1)
			{
				target++;
			}
			else
			{
				target /= 2;
			}
		}
		return ops + current - target;
	}
}
