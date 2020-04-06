import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 06-Apr-20
 */
@LeetCode(id = 11, name = "Container With Most Water", url = "https://leetcode.com/problems/container-with-most-water/")
public class ContainerWithMostWater
{
	public int maxArea(int[] height)
	{
		int maxArea = 0;
		if (height == null || height.length <= 1)
		{
			return maxArea;
		}

		int left = 0;
		int right = height.length - 1;
		while (left < right)
		{
			maxArea = Math.max(maxArea, ((right - left) * Math.min(height[left], height[right])));
			if (height[left] > height[right])
			{
				right--;
			}
			else
			{
				left++;
			}
		}

		return maxArea;
	}

	public static void main(String[] args)
	{
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 2}));
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
		System.out.println(new ContainerWithMostWater().maxArea(new int[]{2,3,4,5,18,17,6}));
	}
}
