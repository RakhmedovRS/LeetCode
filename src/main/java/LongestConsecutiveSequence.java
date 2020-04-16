import common.LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author RakhmedovRS
 * @created 16-Apr-20
 */
@LeetCode(id = 128, name = "Longest Consecutive Sequence", url = "https://leetcode.com/problems/longest-consecutive-sequence/")
public class LongestConsecutiveSequence
{
	public int longestConsecutive(int[] nums)
	{
		int maxLength = 0;
		if (nums == null || nums.length == 0)
		{
			return maxLength;
		}

		Set<Integer> cache = new HashSet<>();
		for (int num : nums)
		{
			cache.add(num);
		}

		int currentCount;
		for (int num : nums)
		{
			currentCount = 1;
			int nextNum = num + 1;
			while (!cache.contains(num - 1) && cache.contains(nextNum))
			{
				nextNum++;
				currentCount++;
			}

			if (currentCount > maxLength)
			{
				maxLength = currentCount;
			}
		}

		return maxLength;
	}

	public static void main(String[] args)
	{
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
	}
}
