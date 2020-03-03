/**
 * Permutation Sequence
 * LeetCode 60
 *
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
public class PermutationSequence
{
	public String getPermutation(int n, int k)
	{
		int[] values = new int[n];
		for (int i = 0; i < n; i++)
		{
			values[i] = i + 1;
		}

		if (n == 1)
		{
			return "1";
		}

		for (int i = 1; i < k; i++)
		{
			nextPermutation(values);
		}

		StringBuilder result = new StringBuilder(values.length);
		for (int value : values)
		{
			result.append(value);
		}
		return result.toString();
	}

	private void nextPermutation(int[] nums)
	{

		int startIndex = nums.length - 2;

		while (startIndex >= 0 && nums[startIndex] >= nums[startIndex + 1])
		{
			startIndex--;
		}

		if (startIndex >= 0)
		{

			int endIndex = nums.length - 1;
			while (endIndex >= 0 && nums[startIndex] >= nums[endIndex])
			{
				endIndex--;
			}

			swap(nums, startIndex, endIndex);
		}

		reverse(nums, startIndex + 1);
	}

	private void reverse(int[] nums, int start)
	{

		int left = start;
		int right = nums.length - 1;

		while (left < right)
		{
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private void swap(int[] nums, int left, int right)
	{
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
