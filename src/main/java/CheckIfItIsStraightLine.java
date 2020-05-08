import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 08-May-20
 */
@LeetCode(id = 1232, name = "Check If It Is a Straight Line", url = "https://leetcode.com/problems/check-if-it-is-a-straight-line/")
public class CheckIfItIsStraightLine
{
	public boolean checkStraightLine(int[][] coordinates)
	{
		int x0 = coordinates[0][0];
		int y0 = coordinates[0][1];
		int x1 = coordinates[1][0];
		int y1 = coordinates[1][1];
		int dx = x1 - x0;
		int dy = y1 - y0;
		for (int[] co : coordinates)
		{
			int x = co[0];
			int y = co[1];
			if (dx * (y - y1) != dy * (x - x1))
			{
				return false;
			}
		}
		return true;
	}
}
