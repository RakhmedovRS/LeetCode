import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 03-Jul-20
 */
@LeetCode(id = 228, name = "Summary Ranges", url = "https://leetcode.com/problems/summary-ranges/")
public class SummaryRanges
{
	public List<String> summaryRanges(int[] nums)
	{
		List<String> ranges = new ArrayList<>();
		Integer prev = null;
		Integer curr = null;
		for (int num : nums)
		{
			if (prev == null)
			{
				prev = num;
				curr = num;
			}
			else if (curr + 1 == num)
			{
				curr = num;
			}
			else
			{
				ranges.add(prev.equals(curr) ? String.valueOf(prev) : prev + "->" + curr);
				prev = num;
				curr = num;
			}
		}

		if (prev != null)
		{
			ranges.add(prev.equals(curr) ? String.valueOf(prev) : prev + "->" + curr);
		}

		return ranges;
	}

	public static void main(String[] args)
	{
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
	}
}
