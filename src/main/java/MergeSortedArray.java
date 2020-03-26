import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 26-Mar-20
 */
@LeetCode(id = 88, name = "Merge Sorted Array", url = "https://leetcode.com/problems/merge-sorted-array/")
public class MergeSortedArray
{
	public void merge(int[] nums1, int m, int[] nums2, int n)
	{
		int[] temp = new int[m];
		for (int i = 0; i < m; i++)
		{
			temp[i] = nums1[i];
		}

		int i = 0, j = 0, idx = 0;
		while (i < m && j < n)
		{
			if (temp[i] > nums2[j])
			{
				nums1[idx++] = nums2[j++];
			}
			else
			{
				nums1[idx++] = temp[i++];
			}
		}

		while (i < m)
		{
			nums1[idx++] = temp[i++];
		}

		while (j < n)
		{
			nums1[idx++] = nums2[j++];
		}
	}
}
