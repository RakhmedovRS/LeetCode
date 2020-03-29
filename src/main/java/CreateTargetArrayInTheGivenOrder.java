import common.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author RakhmedovRS
 * @created 29-Mar-20
 */
@LeetCode(id = 1389, name = "Create Target Array in the Given Order", url = "https://leetcode.com/problems/create-target-array-in-the-given-order/")
public class CreateTargetArrayInTheGivenOrder
{
	public int[] createTargetArray(int[] nums, int[] index)
	{
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < index.length; i++)
		{
			lst.add(index[i], nums[i]);
		}

		int[] res = new int[nums.length];
		for (int i = 0; i < index.length; i++)
		{
			res[i] = lst.get(i);
		}
		return res;
	}

	public static void main(String[] args)
	{
		System.out.println(Arrays.toString(new CreateTargetArrayInTheGivenOrder().createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
	}
}
