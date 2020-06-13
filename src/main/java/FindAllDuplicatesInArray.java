import common.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 13-Jun-20
 */
@LeetCode(id = 442, name = "Find All Duplicates in an Array", url = "https://leetcode.com/problems/find-all-duplicates-in-an-array/")
public class FindAllDuplicatesInArray
{
	public List<Integer> findDuplicates(int[] nums)
	{
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++)
		{
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
			{
				res.add(Math.abs(index + 1));
			}
			nums[index] = -nums[index];
		}
		return res;
	}
}
