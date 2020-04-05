import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 05-Apr-20
 */
@LeetCode(id = 477, name = "Total Hamming Distance", url = "https://leetcode.com/problems/total-hamming-distance/")
public class TotalHammingDistance
{

	public int totalHammingDistance(int[] nums)
	{
		int result = 0;
		int size = nums.length;
		for (int bitPos = 0; bitPos < 32; bitPos++)
		{
			int ones = 0;
			for (int numPos = 0; numPos < size; numPos++)
			{
				if ((nums[numPos] & 1) == 1)
				{
					ones++;
				}
				nums[numPos] = nums[numPos] >>> 1;
			}
			result += ones * (size - ones);
		}
		return result;
	}

	public int totalHammingDistance1(int[] nums)
	{
		if (nums == null || nums.length <= 1)
		{
			return 0;
		}

		int distance = 0;
		for (int first = 0; first < nums.length - 1; first++)
		{
			for (int second = first + 1; second < nums.length; second++)
			{
				distance += hammingDistance(nums[first], nums[second]);
			}
		}
		return distance;
	}

	private int hammingDistance(int first, int second)
	{
		int distance = 0;
		for (int i = 0; i < 32; i++)
		{
			if ((first & 1) != (second & 1))
			{
				distance++;
			}
			first >>= 1;
			second >>= 1;
		}
		return distance;
	}

	public static void main(String[] args)
	{
		System.out.println(new TotalHammingDistance().totalHammingDistance(new int[]{4, 14, 2}));
	}
}
