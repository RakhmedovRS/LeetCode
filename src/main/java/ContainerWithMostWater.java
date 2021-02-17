import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(
	id = 11,
	name = "Container With Most Water",
	url = "https://leetcode.com/problems/container-with-most-water/",
	difficulty = Difficulty.MEDIUM
)
public class ContainerWithMostWater
{
	public int maxArea(int[] height)
	{
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;
		while (left < right)
		{
			maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
			if (height[left] <= height[right])
			{
				left++;
			}
			else
			{
				right--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args)
	{
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2}));
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
	}
}
