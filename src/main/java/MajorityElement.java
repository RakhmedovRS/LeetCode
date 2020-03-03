import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element
 * LeetCode 169
 *
 * @author RakhmedovRS
 * @created 03-Mar-20
 */
public class MajorityElement
{
	public int majorityElement(int[] nums)
	{
		Map<Integer, Integer> cache = new HashMap<>();
		int max = Integer.MIN_VALUE;
		int majorityElementIndex = 0;
		for (int i = 0; i < nums.length; i++)
		{
			int newValue = cache.getOrDefault(nums[i], 0) + 1;
			cache.put(nums[i], newValue);
			if (newValue > max)
			{
				max = newValue;
				majorityElementIndex = i;
			}
		}

		return nums[majorityElementIndex];
	}

	public int majorityElement1(int[] nums)
	{
		int count = 1;
		int majorityElement = nums[0];
		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] == majorityElement)
			{
				count++;
			}
			else
			{
				count--;
			}

			if (count == 0)
			{
				majorityElement = nums[i];
				count++;
			}
		}

		return majorityElement;
	}
}
