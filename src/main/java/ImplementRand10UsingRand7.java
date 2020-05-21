import common.LeetCode;

import java.util.Random;

/**
 * @author RakhmedovRS
 * @created 21-May-20
 */
@LeetCode(id = 470, name = "Implement Rand10() Using Rand7()", url = "https://leetcode.com/problems/implement-rand10-using-rand7/")
public class ImplementRand10UsingRand7
{
	private abstract class SolBase
	{
		int rand7()
		{
			return new Random().nextInt(7);
		}
	}

	class Solution extends SolBase
	{
		public int rand10()
		{
			while (true)
			{
				int num = (rand7() - 1) * 7 + (rand7() - 1);
				if (num < 40)
				{
					return num % 10 + 1;
				}
			}
		}
	}
}
