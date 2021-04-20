package tasks;

import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Aug-20
 */
@LeetCode(id = 836, name = "Rectangle Overlap", url = "https://leetcode.com/problems/rectangle-overlap/")
public class RectangleOverlap
{
	public boolean isRectangleOverlap(int[] rec1, int[] rec2)
	{
		return (Math.min(rec1[2], rec2[2]) > Math.max(rec1[0], rec2[0]) && // width > 0
			Math.min(rec1[3], rec2[3]) > Math.max(rec1[1], rec2[1]));  // height > 0
	}
}
