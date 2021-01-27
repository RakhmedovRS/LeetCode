import common.Difficulty;
import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 10-Aug-20
 */
@LeetCode(
        id = 280,
        name = "Wiggle Sort",
        url = "https://leetcode.com/problems/wiggle-sort/",
        difficulty = Difficulty.MEDIUM,
        premium = true
)
public class WiggleSort
{
    public void wiggleSort(int[] nums)
    {
        boolean min = true;
        for (int i = 0; i < nums.length - 1; i++)
        {
            if (min)
            {
                if (nums[i] > nums[i + 1])
                {
                    swap(nums, i, i + 1);
                }
            }
            else
            {
                if (nums[i] < nums[i + 1])
                {
                    swap(nums, i, i + 1);
                }
            }

            min = !min;
        }
    }

    private void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
