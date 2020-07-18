import common.LeetCode;

import java.util.Arrays;

/**
 * @author RakhmedovRS
 * @created 18-Jul-20
 */
@LeetCode(id = 556, name = "Next Greater Element III", url = "https://leetcode.com/problems/next-greater-element-iii/")
public class NextGreaterElementIII
{
	public int nextGreaterElement(int n)
	{
		char[] origin = String.valueOf(n).toCharArray();
		int right = origin.length - 2;
		while (right >= 0 && origin[right] >= origin[right + 1])
		{
			right--;
		}

		if (right < 0)
		{
			return -1;
		}

		int left = origin.length - 1;
		while (origin[left] <= origin[right])
		{
			left--;
		}

		char tmp = origin[left];
		origin[left] = origin[right];
		origin[right] = tmp;
		Arrays.sort(origin, left + 1, origin.length);
		long res = Long.parseLong(String.valueOf(origin));

		return res > Integer.MAX_VALUE ? -1 : (int) res;
	}

	public static void main(String[] args)
	{
		System.out.println(new NextGreaterElementIII().nextGreaterElement(12443322));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(230241));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(21));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(315));
		System.out.println(new NextGreaterElementIII().nextGreaterElement(12));
	}
}
