import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 12/21/2020
 */
@LeetCode(
	id = 1064,
	name = "Fixed Point",
	url = "https://leetcode.com/problems/fixed-point/",
	difficulty = Difficulty.EASY,
	premium = true
)
public class FixedPoint
{
	public int fixedPoint(int[] A)
	{
		int candidate = -1;
		int left = 0;
		int middle;
		int right = A.length - 1;
		while (left <= right)
		{
			middle = (left + right) / 2;
			if (A[middle] == middle)
			{
				candidate = A[middle];
				right = middle - 1;
				continue;
			}

			if (A[middle] <= middle)
			{
				left = middle + 1;
			}
			else
			{
				right = middle - 1;
			}
		}

		return candidate;
	}

	public static void main(String[] args)
	{
		FixedPoint clazz = new FixedPoint();
		System.out.println(clazz.fixedPoint(new int[]{-10, -5, -2, 0, 4, 5, 6, 7, 8, 9, 10}));
	}
}
