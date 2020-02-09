/**
 * Number of Steps to Reduce a Number to Zero
 * LeetCode 1342
 *
 * @author RakhmedovRS
 * @created 09-Feb-20
 */
public class NumberOfStepsToReduceNumberToZero
{
	public int numberOfSteps(int num)
	{
		int steps = 0;
		while (num != 0)
		{
			if (num % 2 == 0)
			{
				num /= 2;
			}
			else
			{
				num--;
			}

			steps++;
		}

		return steps;
	}
}
