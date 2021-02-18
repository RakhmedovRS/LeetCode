import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 2/14/2021
 */
@LeetCode(
	id = 1760,
	name = "Minimum Limit of Balls in a Bag",
	url = "https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/",
	difficulty = Difficulty.MEDIUM
)
public class MinimumLimitOfBallsInBag
{
	public int minimumSize(int[] nums, int maxOperations)
	{
		int left = 1;
		int mid;
		int right = 1_000_000_000;
		int count;
		while (left < right)
		{
			count = 0;
			mid = (left + right) / 2;
			for (int num : nums)
			{
				count += (num - 1) / mid;
			}

			if (count > maxOperations)
			{
				left = mid + 1;
			}
			else
			{
				right = mid;
			}
		}

		return left;
	}

	public static void main(String[] args)
	{
		MinimumLimitOfBallsInBag clazz = new MinimumLimitOfBallsInBag();
		System.out.println(clazz.minimumSize(new int[]{9}, 2));
		System.out.println(clazz.minimumSize(new int[]{2, 4, 8, 2}, 4));
		System.out.println(clazz.minimumSize(new int[]{7, 17}, 2));
		System.out.println(clazz.minimumSize(new int[]{
				431, 922, 158, 60, 192, 14, 788, 146, 788, 775, 772, 792,
				68, 143, 376, 375, 877, 516, 595, 82, 56, 704, 160, 403, 713, 504, 67, 332, 26},
			80));
	}
}
