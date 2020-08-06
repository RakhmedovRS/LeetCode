import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Aug-20
 */
@LeetCode(id = 492, name = "Construct the Rectangle", url = "https://leetcode.com/problems/construct-the-rectangle/")
public class ConstructTheRectangle
{
	public int[] constructRectangle(int area)
	{
		if (area == 1)
		{
			return new int[]{1, 1};
		}

		int width = (int) Math.sqrt(area);
		while (area % width != 0)
		{
			width--;
		}

		return new int[]{area / width, width};
	}
}
