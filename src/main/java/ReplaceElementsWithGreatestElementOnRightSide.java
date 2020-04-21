import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 21-Apr-20
 */
@LeetCode(id = 1299, name = "Replace Elements with Greatest Element on Right Side", url = "https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/")
public class ReplaceElementsWithGreatestElementOnRightSide
{
	public int[] replaceElements(int[] arr)
	{
		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--)
		{
			int curr = arr[i];
			arr[i] = max;
			if (curr > max)
			{
				max = curr;
			}
		}
		return arr;
	}
}
