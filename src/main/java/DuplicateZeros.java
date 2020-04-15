import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 15-Apr-20
 */
@LeetCode(id = 1089, name = "Duplicate Zeros", url = "https://leetcode.com/problems/duplicate-zeros/")
public class DuplicateZeros
{
	public void duplicateZeros(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			if (arr[i] == 0 && i + 1 < arr.length)
			{
				for (int j = arr.length - 1; j > i; j--)
				{
					arr[j] = arr[j - 1];
				}
				arr[i + 1] = 0;
				i++;
			}
		}
	}
}
