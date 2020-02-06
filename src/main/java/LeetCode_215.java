/**
 * @author RakhmedovRS
 * @created 06-Feb-20
 */
public class LeetCode_215
{
	private void swap(int[] nums, int left, int right)
	{
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	private int partition(int[] nums, int left, int right)
	{
		int pivot = nums[right];
		int low = left;
		for (int i = left; i < right; i++)
		{
			if (nums[i] < pivot)
			{
				swap(nums, i , low);
				low++;
			}
		}

		swap(nums, low, right);
		return low;
	}

	private void quickSort(int[] nums, int left, int right)
	{
		if (left >= right)
		{
			return;
		}
		int pivot = partition(nums, left, right);
		quickSort(nums, left, pivot - 1);
		quickSort(nums, pivot + 1, right);
	}

	public int findKthLargest(int[] nums, int k) {
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}
}
