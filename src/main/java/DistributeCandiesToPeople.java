import common.LeetCode;

/**
 * @author RakhmedovRS
 * @created 09-Jun-20
 */
@LeetCode(id = 1103, name = "Distribute Candies to People", url = "https://leetcode.com/problems/distribute-candies-to-people/")
public class DistributeCandiesToPeople
{
	public int[] distributeCandies(int candies, int num_people)
	{
		int[] answer = new int[num_people];
		int currPos = 0;
		int currCandies = 1;
		while (candies > 0)
		{
			answer[currPos] += Math.min(candies, currCandies);
			candies -= currCandies;
			currCandies++;
			currPos++;
			currPos %= num_people;
		}

		return answer;
	}
}
