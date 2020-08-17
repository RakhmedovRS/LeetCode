import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 1103, name = "Distribute Candies to People", url = "https://leetcode.com/problems/distribute-candies-to-people/")
public class DistributeCandiesToPeople
{
	class Solution
	{
		public int[] distributeCandies(int candies, int num_people)
		{
			int[] result = new int[num_people];
			for (int i = 0; candies > 0; i++)
			{
				result[i % num_people] += Math.min(candies, i + 1);
				candies -= i + 1;
			}

			return result;
		}
	}
}
